package motorph.ui.employeeRole;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import motorph.ui.*;
import motorph.model.EmployeeTimeLogs;
import motorph.repository.DataHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import motorph.model.User;
import motorph.ui.components.CustomFont;

public class EmployeeAttendance extends javax.swing.JPanel {

    private int currentPage = 1;
    private int rowsPerPage = 13;
    private List<EmployeeTimeLogs> timeLogs;

    private List<EmployeeTimeLogs> filteredLogs = null;

    private User currentUser;
    private JPopupMenu timeMenu;
    private boolean isMenuOpen = false; 

    public EmployeeAttendance(User loggedInUser) {
        this.currentUser = loggedInUser;
        initComponents();
        DateToday.setText("Today is " + java.time.LocalDate.now().toString());

        // Renderer setup
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < attendanceLogTable.getColumnCount(); i++) {
            attendanceLogTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        loadTimeLogsForCurrentUser();
    }

    private void loadTimeLogsForCurrentUser() {
        timeLogs = DataHandler.readEmployeeTimeLogs();

        String userFullName = normalize(currentUser.getFullName());
        System.out.println("🔍 Logged-in user full name (normalized): " + userFullName);
        filteredLogs = new ArrayList<>();

        for (EmployeeTimeLogs log : timeLogs) {
            String logFullName = normalize(log.getFirstName() + " " + log.getLastName());
            if (logFullName.equals(userFullName)) {
                filteredLogs.add(log);
            }
        }

        currentPage = 1;
        updateTablePage(filteredLogs);
    }

    public void loadTimeLogsToTable() {
        timeLogs = DataHandler.readEmployeeTimeLogs(); // Load from CSV or DB
        currentPage = 1;
        updateTablePage();
    }

    private void updateTablePage(List<EmployeeTimeLogs> logsToDisplay) {
        DefaultTableModel model = (DefaultTableModel) attendanceLogTable.getModel();
        model.setRowCount(0);

        int start = (currentPage - 1) * rowsPerPage;
        int end = Math.min(start + rowsPerPage, logsToDisplay.size());

        for (int i = start; i < end; i++) {
            EmployeeTimeLogs log = logsToDisplay.get(i);
            String fullName = log.getFirstName() + " " + log.getLastName();
            String totalHours = calculateHoursWorked(log.getLogIn(), log.getLogOut());

            model.addRow(new Object[] {
                    log.getDate(),
                    log.getLogIn(),
                    log.getLogOut(),
                    totalHours
            });
        }

        int totalPages = (int) Math.ceil((double) logsToDisplay.size() / rowsPerPage);
        lblPageInfo.setText("Page " + currentPage + " of " + totalPages);
        btnPrev.setEnabled(currentPage > 1);
        btnNext.setEnabled(currentPage < totalPages);
    }

    private void updateTablePage() {
        updateTablePage(timeLogs);
    }

    private String calculateHoursWorked(String inTime, String outTime) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
            LocalTime in = LocalTime.parse(inTime.trim(), formatter);
            LocalTime out = LocalTime.parse(outTime.trim(), formatter);
            Duration duration = Duration.between(in, out);
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;
            return String.format("%02d:%02d", hours, minutes);
        } catch (Exception e) {
            System.out.println("Invalid time format: IN=" + inTime + ", OUT" + outTime);
            e.printStackTrace();
            return "Invalid";
        }
    }

    private void updateFilteredTablePage() {
        if (filteredLogs != null) {
            updateTablePage(filteredLogs);
        }
    }

    private void handleTimeIn() {
        String today = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String timeNow = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("H:mm"));
        String empNumber = getEmployeeNumberByFullName(currentUser.getFullName());

        if (empNumber.equals("UNKNOWN")) {
            JOptionPane.showMessageDialog(this, "❌ Could not find your employee number. Please contact HR.");
            return;
        }

        String firstName = getFirstName(currentUser.getFullName());
        String lastName = getLastName(currentUser.getFullName());

        List<EmployeeTimeLogs> logs = DataHandler.readEmployeeTimeLogs();

        // ❌ Block if any open Time In exists for today
        boolean hasOpenTimeIn = logs.stream().anyMatch(log ->
            log.getEmployeeNumber().equals(empNumber) &&
            normalize(log.getFirstName()).equals(normalize(firstName)) &&
            normalize(log.getLastName()).equals(normalize(lastName)) &&
            normalize(log.getDate()).equals(normalize(today)) &&
            !normalize(log.getLogIn()).isBlank() &&
            normalize(log.getLogOut()).isBlank()
        );

        if (hasOpenTimeIn) {
            JOptionPane.showMessageDialog(this, "⚠️ You already timed in today and haven’t timed out yet.");
            return;
        }

        // ✅ Write Time In if no open logs exist
        Path path = Paths.get("resources/Copy of MotorPH Employee Data Time Logs.csv");
        try (
            RandomAccessFile raf = new RandomAccessFile(path.toFile(), "rw")
        ) {
            raf.seek(raf.length());

            // Ensure newline
            if (raf.length() > 0) {
                raf.seek(raf.length() - 1);
                byte lastByte = raf.readByte();
                if (lastByte != '\n') {
                    raf.writeBytes(System.lineSeparator());
                }
            }

            String timeInRow = empNumber + "," + lastName + "," + firstName + "," + today + "," + timeNow + ",";
            raf.writeBytes(timeInRow + System.lineSeparator());

            System.out.println("✅ Time In saved: " + timeInRow);
            JOptionPane.showMessageDialog(this, "🟢 Timed in at " + timeNow);
            loadTimeLogsForCurrentUser();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "❌ Error saving Time In!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void handleTimeOut() {
        String today = normalize(java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
        String timeNow = java.time.LocalTime.now().format(DateTimeFormatter.ofPattern("H:mm"));
        String empNumber = getEmployeeNumberByFullName(currentUser.getFullName());

        String firstName = getFirstName(currentUser.getFullName());
        String lastName = getLastName(currentUser.getFullName());

        Path path = Paths.get("resources/Copy of MotorPH Employee Data Time Logs.csv");
        List<String> updatedLines = new ArrayList<>();
        int matchIndex = -1; // store the latest match

        try (BufferedReader br = Files.newBufferedReader(path)) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", -1);

                if (isFirstLine && line.toLowerCase().contains("employee")) {
                    updatedLines.add(line);
                    isFirstLine = false;
                    continue;
                }

                if (parts.length < 6) {
                    updatedLines.add(line);
                    continue;
                }

                // Normalize values for safe comparison
                String logEmpNum = parts[0].trim();
                String logLastName = normalize(parts[1]);
                String logFirstName = normalize(parts[2]);
                String logDate = normalize(parts[3]);
                String logOut = parts[5].trim();

                // Save the latest matching line index with blank Time Out
                if (
                    logEmpNum.equals(empNumber) &&
                    logLastName.equals(normalize(lastName)) &&
                    logFirstName.equals(normalize(firstName)) &&
                    logDate.equals(today) &&
                    logOut.isBlank()
                ) {
                    matchIndex = updatedLines.size(); // position of this line
                }

                updatedLines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "❌ Error reading time logs!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean found = false;

        if (matchIndex != -1) {
            String[] parts = updatedLines.get(matchIndex).split(",", -1);
            parts[5] = timeNow;
            updatedLines.set(matchIndex, String.join(",", parts));
            found = true;
        }

        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            for (String l : updatedLines) {
                bw.write(l);
                bw.newLine();
            }

            if (found) {
                JOptionPane.showMessageDialog(this, "🔴 Timed out at " + timeNow);
                loadTimeLogsForCurrentUser();
            } else {
                JOptionPane.showMessageDialog(this, "⚠️ No matching Time In found for today.", "Not Found", JOptionPane.WARNING_MESSAGE);
            }

        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "❌ Error saving Time Out!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }





    private String getEmployeeNumberByFullName(String fullName) {
        String normalizedFullName = normalize(fullName);

        return DataHandler.readEmployeeDetails().stream()
            .filter(e -> normalize(e.getFirstName() + " " + e.getLastName()).equals(normalizedFullName))
            .map(e -> e.getEmployeeNumber())
            .findFirst()
            .orElse("UNKNOWN");
    }




    private String normalize(String input) {
        return input == null ? "" : input.trim().replaceAll("\\s+", " ").toLowerCase();
    }

    private String getFirstName(String fullName) {
        return fullName.trim().split(" ")[0]; // Simple fallback
    }

    private String getLastName(String fullName) {
        String[] parts = fullName.trim().split(" ");
        return parts.length > 1 ? parts[parts.length - 1] : ""; // last word
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        sortBttn = new javax.swing.JButton();
        lblSubTitle = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblPageInfo = new javax.swing.JLabel();
        DateToday = new javax.swing.JLabel();
        welcomeMsg = new javax.swing.JLabel();
        dropdown = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        attendanceLogTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(1000, 485));
        setRequestFocusEnabled(false);

        sortBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/motorph/icons/filter.png"))); // NOI18N
        sortBttn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        sortBttn.setBorderPainted(false);
        sortBttn.setFocusPainted(false);
        sortBttn.setMaximumSize(new java.awt.Dimension(35, 35));
        sortBttn.setMinimumSize(new java.awt.Dimension(0, 0));
        sortBttn.setPreferredSize(new java.awt.Dimension(24, 24));
        sortBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortBttnActionPerformed(evt);
            }
        });

        lblSubTitle.setFont(CustomFont.getExtendedSemiBold(20f));
        lblSubTitle.setText("Attendance");

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblPageInfo.setText("Page 1 of 1");

        DateToday.setFont(CustomFont.getExtendedSemiBold(20f));
        DateToday.setText("Today is 11/2/2025");

        welcomeMsg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        welcomeMsg.setText("We hope you are making history today!");

        dropdown.setForeground(new java.awt.Color(0, 153, 204));
        dropdown.setText("Time In/Out");
        dropdown.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 204)));
        dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdownActionPerformed(evt);
            }
        });

        attendanceLogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Time In", "Time Out", "Total Worked Hours"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(attendanceLogTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(welcomeMsg, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(DateToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(lblSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sortBttn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(792, 792, 792)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPageInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DateToday, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(sortBttn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(welcomeMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(lblPageInfo)
                    .addComponent(btnPrev))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void sortBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortBttnActionPerformed
       JPopupMenu sortMenu = new JPopupMenu();

        JMenuItem latestItem = new JMenuItem("Sort Date: Latest");
        JMenuItem oldestItem = new JMenuItem("Sort Date: Oldest");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        latestItem.addActionListener(e -> {
            filteredLogs.sort((a, b) -> 
                LocalDate.parse(b.getDate(), formatter).compareTo(LocalDate.parse(a.getDate(), formatter))
            );
            currentPage = 1;
            updateFilteredTablePage();
        });

        oldestItem.addActionListener(e -> {
            filteredLogs.sort((a, b) -> 
                LocalDate.parse(a.getDate(), formatter).compareTo(LocalDate.parse(b.getDate(), formatter))
            );
            currentPage = 1;
            updateFilteredTablePage();
        });

        sortMenu.add(latestItem);
        sortMenu.add(oldestItem);
        sortMenu.show(sortBttn, 0, sortBttn.getHeight());
    }//GEN-LAST:event_sortBttnActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnPrevActionPerformed
        currentPage--;
        if (filteredLogs != null) {
            updateFilteredTablePage();
        } else {
            updateTablePage(timeLogs);
        }
    }// GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNextActionPerformed
        currentPage++;
        if (filteredLogs != null) {
            updateFilteredTablePage();
        } else {
            updateTablePage(timeLogs);
        }
    }// GEN-LAST:event_btnNextActionPerformed

    private void dropdownActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dropdownActionPerformed
        if (isMenuOpen) {
        timeMenu.setVisible(false);
        isMenuOpen = false;
        return;
        }

        timeMenu = new JPopupMenu();
        
        JMenuItem timeIn = new JMenuItem(" Time In");
        JMenuItem timeOut = new JMenuItem(" Time Out");
        
        int buttonWidth = dropdown.getWidth();
        timeIn.setPreferredSize(new java.awt.Dimension(buttonWidth, timeIn.getPreferredSize().height));
        timeOut.setPreferredSize(new java.awt.Dimension(buttonWidth, timeOut.getPreferredSize().height));


        timeIn.addActionListener(e -> {
            handleTimeIn();
            timeMenu.setVisible(false);
            isMenuOpen = false;
        });

        timeOut.addActionListener(e -> {
            handleTimeOut();
            timeMenu.setVisible(false);
            isMenuOpen = false;
        });

        // Determine if already timed in for today (but not timed out)
        String today = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String empNumber = getEmployeeNumberByFullName(currentUser.getFullName());
        String firstName = getFirstName(currentUser.getFullName());
        String lastName = getLastName(currentUser.getFullName());

        boolean hasOpenTimeIn = DataHandler.readEmployeeTimeLogs().stream().anyMatch(log ->
            log.getEmployeeNumber().equals(empNumber) &&
            normalize(log.getFirstName()).equals(normalize(firstName)) &&
            normalize(log.getLastName()).equals(normalize(lastName)) &&
            normalize(log.getDate()).equals(normalize(today)) &&
            !normalize(log.getLogIn()).isBlank() &&
            normalize(log.getLogOut()).isBlank()
        );

        if (hasOpenTimeIn) {
            timeMenu.add(timeOut); // Only show Time Out if already timed in
        } else {
            timeMenu.add(timeIn);  // Only show Time In if not yet timed in
        }

        timeMenu.show(dropdown, 0, dropdown.getHeight());
        isMenuOpen = true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DateToday;
    private javax.swing.JTable attendanceLogTable;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton dropdown;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPageInfo;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JButton sortBttn;
    private javax.swing.JLabel welcomeMsg;
    // End of variables declaration//GEN-END:variables
}

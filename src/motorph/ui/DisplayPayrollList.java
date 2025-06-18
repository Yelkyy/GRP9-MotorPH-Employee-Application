package motorph.ui;


import motorph.ui.components.CustomFont;


import java.util.List;
import javax.swing.JFrame;

import javax.swing.table.DefaultTableModel;
import motorph.model.EmployeeDetails;
import motorph.model.EmployeeTimeLogs;
import motorph.repository.DataHandler;
import motorph.service.PayrollService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;





public class DisplayPayrollList extends javax.swing.JDialog {
    
    private int currentPage = 1;
    private final int rowsPerPage = 15;
    private int totalPages = 1;
    private String currentPayDate;

    public DisplayPayrollList(JFrame parent) {
        super(parent, "Payroll Details", true);
        initComponents();
        applyCustomFontAndSizes();

        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        for (int i = 0; i < empListTable.getColumnCount(); i++) {
            empListTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    private void applyCustomFontAndSizes() {
        title.setFont(CustomFont.getExtendedSemiBold(14f));
        totalEmp.setFont(CustomFont.getExtendedSemiBold(10f));
        payPeriod.setFont(CustomFont.getExtendedSemiBold(10f));
        payDay.setFont(CustomFont.getExtendedSemiBold(10f));
        payrollType.setFont(CustomFont.getExtendedSemiBold(10f));
        displayPayPeriod.setFont(CustomFont.getExtendedRegular(12f));
        displayDate.setFont(CustomFont.getExtendedRegular(12f));
        displayPayrollType.setFont(CustomFont.getExtendedRegular(12f));
        noOfEmp.setFont(CustomFont.getExtendedRegular(12f));    
    }

    
    public void setPayPeriod(String period) {
        displayPayPeriod.setText(period);
    }

    public void setPayDay(String payDay) {
        displayDate.setText(payDay);
    }

    public void setTotalEmployees(int count) {
        noOfEmp.setText(String.valueOf(count));
    }

    public void setPayrollType(String type) {
        displayPayrollType.setText(type);
    }

    public void setTableData(String payDate) {
        this.currentPayDate = payDate;
        
        List<EmployeeDetails> employees = DataHandler.readEmployeeDetails();
        List<EmployeeTimeLogs> timeLogs = DataHandler.readEmployeeTimeLogs();

        DefaultTableModel model = (DefaultTableModel) empListTable.getModel();
        model.setRowCount(0);

        int totalRecords = employees.size();
        totalPages = (int) Math.ceil((double) totalRecords / rowsPerPage);
        int startIndex = (currentPage - 1) * rowsPerPage;
        int endIndex = Math.min(startIndex + rowsPerPage, totalRecords);
        int payPeriod = extractPayPeriodFromDate(payDate);

        // ✅ Parse "June 15, 2024" to LocalDate, then get MM-yyyy
        DateTimeFormatter fullDateFmt = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        LocalDate parsedDate = LocalDate.parse(payDate, fullDateFmt);
        String monthYear = parsedDate.format(DateTimeFormatter.ofPattern("MM-yyyy"));

        for (int i = startIndex; i < endIndex; i++) {
            EmployeeDetails emp = employees.get(i);
            
        List<EmployeeTimeLogs> empLogs = timeLogs.stream()
            .filter(log -> log.getEmployeeNumber().equals(emp.getEmployeeNumber()))
            .filter(log -> {
                LocalDate logDate = LocalDate.parse(log.getDate());
                return isInPayPeriod(logDate, parsedDate);
            })
            .toList();

        double netPay = PayrollService.calculateNetPay(emp, empLogs, monthYear, payPeriod);

            
            String paymentStr = String.format("₱%,.2f", netPay);

            model.addRow(new Object[]{
                emp.getEmployeeId(),
                emp.getFullName(),
                paymentStr,
                emp.getPosition(),
            });
    }
    
    

    lblPageInfo.setText("Page " + currentPage + " of " + totalPages);
    btnPrev.setEnabled(currentPage > 1);
    btnNext.setEnabled(currentPage < totalPages);
}

    
    private int extractPayPeriodFromDate(String payDate) {
        try {
            String[] parts = payDate.split(" ");
            int day = Integer.parseInt(parts[1].replace(",", ""));
            return (day <= 15) ? 1 : 2;
        } catch (Exception e) {
            e.printStackTrace();
            return 1; // fallback to 1
        }
    }
    
    private boolean isInPayPeriod(LocalDate logDate, LocalDate cutoffDate) {
        LocalDate startDate;
        if (cutoffDate.getDayOfMonth() == 15) {
            startDate = cutoffDate.withDayOfMonth(1);
        } else {
            startDate = cutoffDate.withDayOfMonth(16);
        }
        return !logDate.isBefore(startDate) && !logDate.isAfter(cutoffDate);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paySumP = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        empListTable = new javax.swing.JTable();
        payrollRepBox = new javax.swing.JPanel();
        totalEmp = new javax.swing.JLabel();
        displayPayPeriod = new javax.swing.JLabel();
        payPeriod = new javax.swing.JLabel();
        noOfEmp = new javax.swing.JLabel();
        payDay = new javax.swing.JLabel();
        payrollType = new javax.swing.JLabel();
        displayDate = new javax.swing.JLabel();
        displayPayrollType = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        lblPageInfo = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();

        setTitle("Employee Information");
        setMinimumSize(new java.awt.Dimension(993, 720));
        setName("displayEmpFrame"); // NOI18N
        setResizable(false);

        paySumP.setBackground(new java.awt.Color(255, 255, 255));
        paySumP.setMaximumSize(new java.awt.Dimension(1054, 720));
        paySumP.setMinimumSize(new java.awt.Dimension(1054, 720));
        paySumP.setPreferredSize(new java.awt.Dimension(1054, 720));

        title.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        title.setText("Payroll Summary Report");

        empListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Employee #", "Employee Name", "Payment Amount", "Job Title"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(empListTable);

        payrollRepBox.setBackground(new java.awt.Color(0, 66, 102));
        payrollRepBox.setForeground(new java.awt.Color(255, 255, 255));
        payrollRepBox.setMaximumSize(new java.awt.Dimension(911, 127));
        payrollRepBox.setMinimumSize(new java.awt.Dimension(911, 127));
        payrollRepBox.setName(""); // NOI18N
        payrollRepBox.setPreferredSize(new java.awt.Dimension(911, 127));

        totalEmp.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        totalEmp.setForeground(new java.awt.Color(255, 255, 255));
        totalEmp.setText("Total Employee");

        displayPayPeriod.setForeground(new java.awt.Color(255, 255, 255));
        displayPayPeriod.setText("April 1st - 15th, 2025");

        payPeriod.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        payPeriod.setForeground(new java.awt.Color(255, 255, 255));
        payPeriod.setText("Pay Period");

        noOfEmp.setForeground(new java.awt.Color(255, 255, 255));
        noOfEmp.setText("34");

        payDay.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        payDay.setForeground(new java.awt.Color(255, 255, 255));
        payDay.setText("Pay Day");

        payrollType.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        payrollType.setForeground(new java.awt.Color(255, 255, 255));
        payrollType.setText("Payroll Type");

        displayDate.setForeground(new java.awt.Color(255, 255, 255));
        displayDate.setText("April 15, 2025");

        displayPayrollType.setForeground(new java.awt.Color(255, 255, 255));
        displayPayrollType.setText("Regular");

        javax.swing.GroupLayout payrollRepBoxLayout = new javax.swing.GroupLayout(payrollRepBox);
        payrollRepBox.setLayout(payrollRepBoxLayout);
        payrollRepBoxLayout.setHorizontalGroup(
            payrollRepBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payrollRepBoxLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(payrollRepBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payPeriod)
                    .addComponent(totalEmp)
                    .addComponent(noOfEmp)
                    .addComponent(displayPayPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
                .addGroup(payrollRepBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(payDay, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayDate, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(payrollType, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayPayrollType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        payrollRepBoxLayout.setVerticalGroup(
            payrollRepBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payrollRepBoxLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(payrollRepBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payPeriod)
                    .addComponent(payDay))
                .addGap(3, 3, 3)
                .addGroup(payrollRepBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(displayPayPeriod)
                    .addComponent(displayDate))
                .addGap(22, 22, 22)
                .addGroup(payrollRepBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalEmp)
                    .addComponent(payrollType))
                .addGap(3, 3, 3)
                .addGroup(payrollRepBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noOfEmp)
                    .addComponent(displayPayrollType))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnNext.setText(">");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblPageInfo.setText("Page 1 of 1");

        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout paySumPLayout = new javax.swing.GroupLayout(paySumP);
        paySumP.setLayout(paySumPLayout);
        paySumPLayout.setHorizontalGroup(
            paySumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paySumPLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(paySumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paySumPLayout.createSequentialGroup()
                        .addGroup(paySumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payrollRepBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paySumPLayout.createSequentialGroup()
                        .addGroup(paySumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(paySumPLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnPrev)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPageInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNext)))
                        .addGap(110, 110, 110))))
        );
        paySumPLayout.setVerticalGroup(
            paySumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paySumPLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(payrollRepBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(paySumPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(lblPageInfo)
                    .addComponent(btnNext))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paySumP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(paySumP, javax.swing.GroupLayout.PREFERRED_SIZE, 663, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        if (currentPage > 1) {
            currentPage--;
            setTableData(currentPayDate);
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (currentPage < totalPages) {
            currentPage++;
            setTableData(currentPayDate); 
        }
    }//GEN-LAST:event_btnNextActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JLabel displayDate;
    private javax.swing.JLabel displayPayPeriod;
    private javax.swing.JLabel displayPayrollType;
    private javax.swing.JTable empListTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPageInfo;
    private javax.swing.JLabel noOfEmp;
    private javax.swing.JLabel payDay;
    private javax.swing.JLabel payPeriod;
    private javax.swing.JPanel paySumP;
    private javax.swing.JPanel payrollRepBox;
    private javax.swing.JLabel payrollType;
    private javax.swing.JLabel title;
    private javax.swing.JLabel totalEmp;
    // End of variables declaration//GEN-END:variables
}

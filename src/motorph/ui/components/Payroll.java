package motorph.ui.components;


import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import motorph.model.EmployeeDetails;
import motorph.model.EmployeeTimeLogs;
import motorph.repository.DataHandler;
import motorph.service.PayrollService;



public class Payroll extends javax.swing.JPanel {
    
    private int currentPage = 1;
    private final int rowsPerPage = 10;
    private int totalPages = 1;
    private List<EmployeeDetails> allEmployees;
    private List<Double> allNetPays;


    List<EmployeeDetails> employees = DataHandler.readEmployeeDetails();
    
    List<EmployeeTimeLogs> timeLogs = DataHandler.readEmployeeTimeLogs();
    
    private void applyCustomFont() {
        lblSubTitle2.setFont(CustomFont.getExtendedSemiBold(14f));
        jtitle1.setFont(CustomFont.getExtendedSemiBold(10f));
        jtitle2.setFont(CustomFont.getExtendedSemiBold(10f));
        jtitle3.setFont(CustomFont.getExtendedSemiBold(10f));
        jtitle4.setFont(CustomFont.getExtendedSemiBold(10f));
        jtitle5.setFont(CustomFont.getExtendedSemiBold(10f));
        jtitle6.setFont(CustomFont.getExtendedSemiBold(10f));
        jSubTitle1.setFont(CustomFont.getExtendedRegular(12f));
        jSubTitle2.setFont(CustomFont.getExtendedRegular(12f));
        jSubTitle3.setFont(CustomFont.getExtendedRegular(12f));
        jSubTitle4.setFont(CustomFont.getExtendedRegular(12f));
        jSubTitle5.setFont(CustomFont.getExtendedRegular(12f));
        jSubTitle6.setFont(CustomFont.getExtendedRegular(12f));
        jLabel10.setFont(CustomFont.getExtendedSemiBold(12f));
        
        
    }

    public Payroll() {
        initComponents();
        applyCustomFont();
        setColumnWidths();
        

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < allPaymentTable.getColumnCount(); i++) {
            allPaymentTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        generatePayroll();
    }   
    
    public void loadPayrollData(List<EmployeeDetails> employees, List<Double> netPays, String paymentDate) {
        DefaultTableModel model = (DefaultTableModel) allPaymentTable.getModel();
        model.setRowCount(0); // Clear any existing rows

            for (int i = 0; i < employees.size(); i++) {
                EmployeeDetails emp = employees.get(i);
                double netPay = netPays.get(i);

                model.addRow(new Object[]{
                    emp.getEmployeeNumber(),
                    emp.getFullName(),
                    paymentDate,
                    String.format("PHP %,.2f", netPay),
                    emp.getPosition(),
                    "Paid" // Or you can use logic here if you need status
                });
            }
    }
    
    private void generatePayroll() {
        String payPeriod = "04-2025"; 
        int periodPart = 1; // 1st–15th, change to 2 if 16th–30th
        String paymentDate = "April 15, 2025";

        allEmployees = new ArrayList<>();
        allNetPays = new ArrayList<>();

        for (EmployeeDetails emp : employees) {
            List<EmployeeTimeLogs> logsForEmp = new ArrayList<>();

            for (EmployeeTimeLogs log : timeLogs) {
                if (log.getEmployeeNumber().equals(emp.getEmployeeNumber())) {
                    logsForEmp.add(log);
                }
            }

            double netPay = PayrollService.calculateNetPay(emp, logsForEmp, payPeriod, periodPart);
            allEmployees.add(emp);
            allNetPays.add(netPay);
        }
        
        totalPages = (int) Math.ceil((double) allEmployees.size() / rowsPerPage);
        currentPage = 1;
        
        updateTablePage();
    }
    
    private void updateTablePage() {
        int start = (currentPage - 1) * rowsPerPage;
        int end = Math.min(start + rowsPerPage, allEmployees.size());

        List<EmployeeDetails> pageEmployees = allEmployees.subList(start, end);
        List<Double> pageNetPays = allNetPays.subList(start, end);

        loadPayrollData(pageEmployees, pageNetPays, "April 15, 2025");

        lblPageInfo.setText("Page " + currentPage + " of " + totalPages);

        btnPrev.setEnabled(currentPage > 1);
        btnNext.setEnabled(currentPage < totalPages);
    }


    private void setColumnWidths() {
            TableColumnModel columnModel = allPaymentTable.getColumnModel();

            // Example: Assuming Position is column 1, Status is column 2
            columnModel.getColumn(4).setPreferredWidth(150);  // Position wider
            columnModel.getColumn(5).setPreferredWidth(70);   // Status narrower

            // Optionally set min/max widths to prevent resizing issues
            columnModel.getColumn(5).setMinWidth(50);
            columnModel.getColumn(5).setMaxWidth(100);
        }
    


       
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        allPaymentTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();
        boarder1 = new javax.swing.JSeparator();
        lblSubTitle = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblPageInfo = new javax.swing.JLabel();
        lblSubTitle2 = new javax.swing.JLabel();
        payrollRep1 = new javax.swing.JPanel();
        jtitle2 = new javax.swing.JLabel();
        jSubTitle1 = new javax.swing.JLabel();
        jtitle1 = new javax.swing.JLabel();
        jSubTitle2 = new javax.swing.JLabel();
        jtitle3 = new javax.swing.JLabel();
        jtitle4 = new javax.swing.JLabel();
        jSubTitle3 = new javax.swing.JLabel();
        jSubTitle4 = new javax.swing.JLabel();
        payrollRep2 = new javax.swing.JPanel();
        jtitle5 = new javax.swing.JLabel();
        jSubTitle5 = new javax.swing.JLabel();
        jtitle6 = new javax.swing.JLabel();
        jSubTitle6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1054, 720));
        setMinimumSize(new java.awt.Dimension(1054, 720));
        setPreferredSize(new java.awt.Dimension(1054, 720));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        allPaymentTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        allPaymentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Employee #", "Employee Name", "Payment Date", "Payment Amount", "Job Title", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        allPaymentTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(allPaymentTable);
        if (allPaymentTable.getColumnModel().getColumnCount() > 0) {
            allPaymentTable.getColumnModel().getColumn(0).setResizable(false);
            allPaymentTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            allPaymentTable.getColumnModel().getColumn(1).setResizable(false);
            allPaymentTable.getColumnModel().getColumn(2).setResizable(false);
            allPaymentTable.getColumnModel().getColumn(3).setResizable(false);
            allPaymentTable.getColumnModel().getColumn(4).setResizable(false);
        }

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/motorph/icons/search.png"))); // NOI18N
        searchButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setFocusPainted(false);
        searchButton.setMaximumSize(new java.awt.Dimension(35, 35));
        searchButton.setMinimumSize(new java.awt.Dimension(0, 0));
        searchButton.setPreferredSize(new java.awt.Dimension(24, 24));
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchBar.setBackground(new java.awt.Color(238, 238, 238));
        searchBar.setForeground(new java.awt.Color(153, 153, 153));
        searchBar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchBar.setText("Search Employee by ID");
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });
        searchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchBarKeyPressed(evt);
            }
        });

        boarder1.setBackground(new java.awt.Color(0, 66, 102));
        boarder1.setForeground(new java.awt.Color(0, 66, 102));

        lblSubTitle.setFont(CustomFont.getExtendedSemiBold(20f));
        lblSubTitle.setText("Payroll Report");

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

        lblSubTitle2.setText("All Payments");

        jtitle2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jtitle2.setText("Total Employee");

        jSubTitle1.setText("April 1st - 15th, 2025");

        jtitle1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jtitle1.setText("Pay Period");

        jSubTitle2.setText("34");

        jtitle3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jtitle3.setText("Pay Day");

        jtitle4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jtitle4.setText("Payroll Type");

        jSubTitle3.setText("April 15, 2025");

        jSubTitle4.setText("Regular");

        javax.swing.GroupLayout payrollRep1Layout = new javax.swing.GroupLayout(payrollRep1);
        payrollRep1.setLayout(payrollRep1Layout);
        payrollRep1Layout.setHorizontalGroup(
            payrollRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payrollRep1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(payrollRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtitle1)
                    .addComponent(jSubTitle1)
                    .addComponent(jtitle2)
                    .addComponent(jSubTitle2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                .addGroup(payrollRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtitle3)
                    .addComponent(jtitle4)
                    .addComponent(jSubTitle3)
                    .addComponent(jSubTitle4))
                .addGap(36, 36, 36))
        );
        payrollRep1Layout.setVerticalGroup(
            payrollRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payrollRep1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(payrollRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtitle1)
                    .addComponent(jtitle3))
                .addGap(3, 3, 3)
                .addGroup(payrollRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSubTitle1)
                    .addComponent(jSubTitle3))
                .addGap(22, 22, 22)
                .addGroup(payrollRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtitle2)
                    .addComponent(jtitle4))
                .addGap(3, 3, 3)
                .addGroup(payrollRep1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSubTitle2)
                    .addComponent(jSubTitle4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtitle5.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jtitle5.setText("Total Working Hours");

        jSubTitle5.setText("320.00 Hrs");

        jtitle6.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jtitle6.setText("Total Time Off");

        jSubTitle6.setText("120.00 Hrs");

        jLabel10.setText("Worked Hour Summary");

        javax.swing.GroupLayout payrollRep2Layout = new javax.swing.GroupLayout(payrollRep2);
        payrollRep2.setLayout(payrollRep2Layout);
        payrollRep2Layout.setHorizontalGroup(
            payrollRep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payrollRep2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(payrollRep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(payrollRep2Layout.createSequentialGroup()
                        .addGroup(payrollRep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtitle5)
                            .addComponent(jSubTitle5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                        .addGroup(payrollRep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtitle6)
                            .addComponent(jSubTitle6))
                        .addGap(43, 43, 43))
                    .addGroup(payrollRep2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        payrollRep2Layout.setVerticalGroup(
            payrollRep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payrollRep2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addGap(33, 33, 33)
                .addGroup(payrollRep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtitle5)
                    .addComponent(jtitle6))
                .addGap(3, 3, 3)
                .addGroup(payrollRep2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSubTitle5)
                    .addComponent(jSubTitle6))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boarder1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(882, 882, 882)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPageInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext)))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(payrollRep1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(payrollRep2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblSubTitle2)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(boarder1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lblSubTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(payrollRep2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(payrollRep1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(24, 24, 24)
                .addComponent(lblSubTitle2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(lblPageInfo))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        // Manually added the FocusListener below the searchBar setup
        searchBar.addFocusListener(new java.awt.event.FocusListener() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchBar.getText().equals("Search Employee by ID")) {
                    searchBar.setText(""); // Clear the text when clicked
                    searchBar.setForeground(new java.awt.Color(0, 0, 0)); // Set text color to black
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchBar.getText().isEmpty()) {
                    searchBar.setText("Search Employee by ID"); // Restore the placeholder text if empty
                    searchBar.setForeground(new java.awt.Color(153, 153, 153)); // Set text color to gray
                }
            }
        });

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents
        
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed

    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchBarActionPerformed

    private void searchBarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBarKeyPressed


    }//GEN-LAST:event_searchBarKeyPressed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
       if (currentPage > 1) {
           currentPage--;
           updateTablePage();
       }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        if (currentPage < totalPages) {
            currentPage++;
            updateTablePage();
        }
    }//GEN-LAST:event_btnNextActionPerformed

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable allPaymentTable;
    private javax.swing.JSeparator boarder1;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSubTitle1;
    private javax.swing.JLabel jSubTitle2;
    private javax.swing.JLabel jSubTitle3;
    private javax.swing.JLabel jSubTitle4;
    private javax.swing.JLabel jSubTitle5;
    private javax.swing.JLabel jSubTitle6;
    private javax.swing.JLabel jtitle1;
    private javax.swing.JLabel jtitle2;
    private javax.swing.JLabel jtitle3;
    private javax.swing.JLabel jtitle4;
    private javax.swing.JLabel jtitle5;
    private javax.swing.JLabel jtitle6;
    private javax.swing.JLabel lblPageInfo;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblSubTitle2;
    private javax.swing.JPanel payrollRep1;
    private javax.swing.JPanel payrollRep2;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}

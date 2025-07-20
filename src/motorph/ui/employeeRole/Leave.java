package motorph.ui.employeeRole;

import com.toedter.calendar.JDateChooser;
import motorph.model.User;
import motorph.ui.components.CustomFont;

public class Leave extends javax.swing.JPanel {  

    private final User loggedInUser;

    public Leave(User loggedInUser) {
        this.loggedInUser = loggedInUser;
        initComponents();
        applyCustomFont();
        alignTableColumnsCenter();
    }

    
    private void applyCustomFont() {
        welcomeMsg.setFont(CustomFont.getExtendedRegular(16f));
        
    }
    
    private void addLeaveToTable(motorph.utils.LeaveRequest leave) {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) leaveListTable.getModel();

        java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("MM-dd-yyyy");

        String requestDate = df.format(leave.getRequestDate());
        String fromDate = df.format(leave.getFrom());
        String toDate = df.format(leave.getTo());

        long days = (leave.getTo().getTime() - leave.getFrom().getTime()) / (1000 * 60 * 60 * 24) + 1;

        model.addRow(new Object[] {
            requestDate,
            fromDate,
            toDate,
            days,
            leave.getStatus()
        });
    }

    
    private void clearForm() {
        fromDateChooser.setDate(null);        
        toDateChooser.setDate(null);         
        reason.setText("");               
        leaveLeaveType.setSelected(true);      
        optionalLeaveType.setSelected(false);   
    }

    private void alignTableColumnsCenter() {
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        for (int i = 0; i < leaveListTable.getColumnCount(); i++) {
            leaveListTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }


            
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeMsg = new javax.swing.JLabel();
        boarder1 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        leaveLeaveType = new javax.swing.JRadioButton();
        optionalLeaveType = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reason = new javax.swing.JTextArea();
        applyLeaveButton = new javax.swing.JButton();
        cancelLeaveButton = new javax.swing.JButton();
        toDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        fromDateChooser = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaveListTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(1000, 485));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.lightGray));

        welcomeMsg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        welcomeMsg.setText("Request new leave");

        boarder1.setBackground(new java.awt.Color(0, 66, 102));
        boarder1.setForeground(new java.awt.Color(0, 66, 102));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel13.setText("Leave Type:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel14.setText("From:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel15.setText("Reason:");

        leaveLeaveType.setText("Leave");

        optionalLeaveType.setText("Optional");

        reason.setColumns(20);
        reason.setRows(5);
        jScrollPane2.setViewportView(reason);

        applyLeaveButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        applyLeaveButton.setForeground(new java.awt.Color(255, 255, 255));
        applyLeaveButton.setText("Apply Leave");
        applyLeaveButton.setBorder(null);
        applyLeaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyLeaveButtonActionPerformed(evt);
            }
        });

        cancelLeaveButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        cancelLeaveButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelLeaveButton.setText("Cancel");
        cancelLeaveButton.setBorder(null);
        cancelLeaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelLeaveButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel16.setText("To:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boarder1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cancelLeaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(applyLeaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(welcomeMsg)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(leaveLeaveType, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(optionalLeaveType, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                        .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(welcomeMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boarder1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leaveLeaveType)
                    .addComponent(optionalLeaveType))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyLeaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelLeaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        leaveListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Reqest Date", "From", "To", "Days", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leaveListTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void applyLeaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyLeaveButtonActionPerformed
        java.util.Date from = fromDateChooser.getDate();
        java.util.Date to = toDateChooser.getDate();
        String type = leaveLeaveType.isSelected() ? "Leave" : "Optional";
        String noteText = reason.getText();

        if (from == null || to == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please select both FROM and TO dates.");
            return;
        }

        if (from.after(to)) {
            javax.swing.JOptionPane.showMessageDialog(this, "'From' date cannot be after 'To' date.");
            return;
        }

        motorph.utils.LeaveRequest leave = new motorph.utils.LeaveRequest(
            new java.util.Date(), // requestDate = now
            from,
            to,
            noteText,
            type,
            "Pending"
        );

        addLeaveToTable(leave);

        motorph.utils.LeaveRequest.saveToCSV(loggedInUser.getEmployeeId(), leave);

        clearForm();
        javax.swing.JOptionPane.showMessageDialog(this, "Leave request submitted.");
    }//GEN-LAST:event_applyLeaveButtonActionPerformed

    private void cancelLeaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelLeaveButtonActionPerformed
        clearForm();
    }//GEN-LAST:event_cancelLeaveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyLeaveButton;
    private javax.swing.JSeparator boarder1;
    private javax.swing.JButton cancelLeaveButton;
    private com.toedter.calendar.JDateChooser fromDateChooser;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton leaveLeaveType;
    private javax.swing.JTable leaveListTable;
    private javax.swing.JRadioButton optionalLeaveType;
    private javax.swing.JTextArea reason;
    private com.toedter.calendar.JDateChooser toDateChooser;
    private javax.swing.JLabel welcomeMsg;
    // End of variables declaration//GEN-END:variables
}

package motorph.ui.components;

import java.util.List;
import javax.swing.JFrame;
import motorph.model.EmployeeDetails;
import motorph.repository.DataHandler;



public class DisplayEmployeeInfo extends javax.swing.JDialog {
    
    

    public DisplayEmployeeInfo(JFrame parent, String employeeNumber) {
        super(parent, "Employee Info", true);

        initComponents();
        applyCustomFont();
        setLocationRelativeTo(parent);       
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        loadEmployeeDetails(employeeNumber);
        pack();
    }
    
    private void loadEmployeeDetails(String employeeNumber) {
    List<EmployeeDetails> allEmployees = DataHandler.readEmployeeDetails();
    for (EmployeeDetails emp : allEmployees) {
        if (emp.getEmployeeNumber().equals(employeeNumber)) {
            // Personal Info
            empNum.setText(emp.getEmployeeNumber());
            firstName.setText(emp.getFirstName());
            lastName.setText(emp.getLastName());
            birthday.setText(emp.getBirthday());
            address.setText(emp.getAddress());
            phoneNum.setText(emp.getPhoneNumber());
            sssNum.setText(emp.getSssNumber());
            philHealthNum.setText(emp.getPhilhealthNumber());
            tinNum.setText(emp.getTinNumber());
            pagIbigNum.setText(emp.getPagIbigNumber());

            // Job Info
            empStatus.setText(emp.getStatus());
            empPosition.setText(emp.getPosition());
            empSupervisor.setText(emp.getImmediateSupervisor());

            // Salary Info
            empBasicSalary.setText(String.format("%.2f", emp.getBasicSalary()));
            empRiceSubsidy.setText(String.format("%.2f", emp.getRiceSubsidy()));
            empPhoneAllwc.setText(String.format("%.2f", emp.getPhoneAllowance()));
            empClothingAllwc.setText(String.format("%.2f", emp.getClothingAllowance()));
            empSemiMonthlyRate.setText(String.format("%.2f", emp.getGrossSemiMonthlyRate()));
            empHourlyRate.setText(String.format("%.2f", emp.getHourlyRate()));

            // Display Full Name
            empFullName.setText(emp.getFullName());

            break; // Employee found
        }
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        empFullName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        empNum = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lastName = new javax.swing.JTextField();
        birthday = new javax.swing.JTextField();
        firstName = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        phoneNum = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        sssNum = new javax.swing.JTextField();
        philHealthNum = new javax.swing.JTextField();
        tinNum = new javax.swing.JTextField();
        pagIbigNum = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        empStatus = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        empPosition = new javax.swing.JTextField();
        empSupervisor = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        empBasicSalary = new javax.swing.JTextField();
        empRiceSubsidy = new javax.swing.JTextField();
        empPhoneAllwc = new javax.swing.JTextField();
        empClothingAllwc = new javax.swing.JTextField();
        empSemiMonthlyRate = new javax.swing.JTextField();
        empHourlyRate = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        editEmpButton = new javax.swing.JButton();

        setTitle("Employee Info");
        setMaximumSize(new java.awt.Dimension(1054, 720));
        setMinimumSize(new java.awt.Dimension(993, 720));
        setName("displayEmpFrame"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1054, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1054, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1054, 720));

        empFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empFullName.setText("Fist Name Last Name");

        jLabel3.setText("Employee Number:");

        empNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNumActionPerformed(evt);
            }
        });

        jLabel4.setText("First Name:");

        jLabel5.setText("Last Name:");

        jLabel6.setText("Date of Birth:");

        jLabel7.setText("Address:");

        jLabel8.setText("Phone Number:");

        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });

        birthday.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birthdayActionPerformed(evt);
            }
        });

        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        phoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumActionPerformed(evt);
            }
        });

        jLabel9.setText("SSS:");

        jLabel10.setText("PhilHealth:");

        jLabel11.setText("TIN:");

        jLabel12.setText("Pag-IBIG:");

        sssNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sssNumActionPerformed(evt);
            }
        });

        philHealthNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                philHealthNumActionPerformed(evt);
            }
        });

        tinNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinNumActionPerformed(evt);
            }
        });

        pagIbigNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagIbigNumActionPerformed(evt);
            }
        });

        jLabel13.setText("Status:");

        empStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empStatusActionPerformed(evt);
            }
        });

        jLabel14.setText("Position:");

        jLabel15.setText("Supervisor:");

        empPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empPositionActionPerformed(evt);
            }
        });

        empSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empSupervisorActionPerformed(evt);
            }
        });

        jLabel16.setText("Basic Sallary:");

        jLabel17.setText("Rice Subsidy:");

        jLabel18.setText("Phone Allowance:");

        jLabel19.setText("Clothing Allowance:");

        jLabel20.setText("Hourly Rate:");

        empBasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empBasicSalaryActionPerformed(evt);
            }
        });

        empRiceSubsidy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empRiceSubsidyActionPerformed(evt);
            }
        });

        empPhoneAllwc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empPhoneAllwcActionPerformed(evt);
            }
        });

        empClothingAllwc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empClothingAllwcActionPerformed(evt);
            }
        });

        empSemiMonthlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empSemiMonthlyRateActionPerformed(evt);
            }
        });

        empHourlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empHourlyRateActionPerformed(evt);
            }
        });

        jLabel21.setText("Semi-Monthly Rate:");

        editEmpButton.setBackground(new java.awt.Color(95, 182, 199));
        editEmpButton.setForeground(new java.awt.Color(255, 255, 255));
        editEmpButton.setText("Edit Employee");
        editEmpButton.setBorder(null);
        editEmpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(phoneNum))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(birthday))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lastName))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(firstName))
                        .addComponent(empFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(empNum)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(sssNum))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(philHealthNum))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tinNum))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pagIbigNum, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empSupervisor))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empPosition))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empClothingAllwc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empBasicSalary))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empRiceSubsidy))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(empPhoneAllwc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empHourlyRate)
                            .addComponent(empSemiMonthlyRate))))
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(editEmpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(empFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(empNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(empStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(empPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(empSupervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(birthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(empBasicSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(empRiceSubsidy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(phoneNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(empPhoneAllwc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(empClothingAllwc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(sssNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(philHealthNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tinNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(pagIbigNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empSemiMonthlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(empHourlyRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addGap(23, 23, 23)
                .addComponent(editEmpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void empNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empNumActionPerformed

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameActionPerformed

    private void birthdayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birthdayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birthdayActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void phoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumActionPerformed

    private void sssNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sssNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sssNumActionPerformed

    private void philHealthNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_philHealthNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_philHealthNumActionPerformed

    private void tinNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tinNumActionPerformed

    private void pagIbigNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagIbigNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagIbigNumActionPerformed

    private void empStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empStatusActionPerformed

    private void empPositionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empPositionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empPositionActionPerformed

    private void empSupervisorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empSupervisorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empSupervisorActionPerformed

    private void empBasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empBasicSalaryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empBasicSalaryActionPerformed

    private void empRiceSubsidyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empRiceSubsidyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empRiceSubsidyActionPerformed

    private void empPhoneAllwcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empPhoneAllwcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empPhoneAllwcActionPerformed

    private void empClothingAllwcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empClothingAllwcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empClothingAllwcActionPerformed

    private void empSemiMonthlyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empSemiMonthlyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empSemiMonthlyRateActionPerformed

    private void empHourlyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empHourlyRateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empHourlyRateActionPerformed

    private void editEmpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmpButtonActionPerformed

    }//GEN-LAST:event_editEmpButtonActionPerformed

    private void applyCustomFont() {
        empFullName.setFont(CustomFont.getExtendedSemiBold(14f));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField birthday;
    private javax.swing.JButton editEmpButton;
    private javax.swing.JTextField empBasicSalary;
    private javax.swing.JTextField empClothingAllwc;
    private javax.swing.JLabel empFullName;
    private javax.swing.JTextField empHourlyRate;
    private javax.swing.JTextField empNum;
    private javax.swing.JTextField empPhoneAllwc;
    private javax.swing.JTextField empPosition;
    private javax.swing.JTextField empRiceSubsidy;
    private javax.swing.JTextField empSemiMonthlyRate;
    private javax.swing.JTextField empStatus;
    private javax.swing.JTextField empSupervisor;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastName;
    private javax.swing.JTextField pagIbigNum;
    private javax.swing.JTextField philHealthNum;
    private javax.swing.JTextField phoneNum;
    private javax.swing.JTextField sssNum;
    private javax.swing.JTextField tinNum;
    // End of variables declaration//GEN-END:variables
}

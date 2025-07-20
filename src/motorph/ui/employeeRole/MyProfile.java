package motorph.ui.employeeRole;

import motorph.ui.*;
import motorph.model.EmployeeDetails;
import motorph.model.User;
import motorph.repository.DataHandler;
import motorph.ui.components.CustomFont;

import java.awt.Color;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyProfile extends javax.swing.JPanel {

    List<JTextField> empInfoFieldList;

    public MyProfile(User loggedInUser) {
        initComponents();
        prepareFormUI();
        loadEmployeeDetailsByFullName(loggedInUser.getFullName());
        saveEmpButton.setVisible(false);
        cancelEmpButton.setVisible(false);

    }

    private void prepareFormUI() {
        applyCustomFont();

        empInfoFieldList = Arrays.asList(
            empNum, firstName, lastName, birthday, phoneNum,
            sssNum, philHealthNum, tinNum, pagIbigNum,
            empBasicSalary, empRiceSubsidy, empPhoneAllwc,
            empClothingAllwc, empSemiMonthlyRate, empHourlyRate
        );

        // Lock all initially
        setEditMode(false);

        // Disable comboboxes
        empStatus.setEnabled(false);
        empPosition.setEnabled(false);
        empSupervisor.setEnabled(false);

        // Hide save/cancel initially
        saveEmpButton.setVisible(false);
        cancelEmpButton.setVisible(false);
    }


    private void loadEmployeeDetailsByFullName(String fullName) {
        List<EmployeeDetails> allEmployees = DataHandler.readEmployeeDetails();

        // Normalize and match by full name
        EmployeeDetails emp = allEmployees.stream()
            .filter(e -> normalize(e.getFirstName() + " " + e.getLastName())
                .equals(normalize(fullName)))
            .findFirst()
            .orElse(null);

        if (emp == null) {
            JOptionPane.showMessageDialog(this, "Employee profile not found for: " + fullName, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        empNum.setText(emp.getEmployeeNumber());
        firstName.setText(emp.getFirstName());
        lastName.setText(emp.getLastName());
        birthday.setText(formatDate(emp.getBirthday()));
        address2.setText(emp.getAddress());
        phoneNum.setText(emp.getPhoneNumber());
        sssNum.setText(emp.getSssNumber());
        philHealthNum.setText(emp.getPhilhealthNumber());
        tinNum.setText(emp.getTinNumber());
        pagIbigNum.setText(emp.getPagIbigNumber());

        empStatus.setSelectedItem(emp.getStatus());
        empPosition.setSelectedItem(emp.getPosition());
        empSupervisor.setSelectedItem(emp.getImmediateSupervisor());

        empBasicSalary.setText(String.format("%.2f", emp.getBasicSalary()));
        empRiceSubsidy.setText(String.format("%.2f", emp.getRiceSubsidy()));
        empPhoneAllwc.setText(String.format("%.2f", emp.getPhoneAllowance()));
        empClothingAllwc.setText(String.format("%.2f", emp.getClothingAllowance()));
        empSemiMonthlyRate.setText(String.format("%.2f", emp.getGrossSemiMonthlyRate()));
        empHourlyRate.setText(String.format("%.2f", emp.getHourlyRate()));

        empFullName.setText(emp.getFullName());
    }

    private String formatDate(String rawBirthday) {
        try {
            Date parsedDate = new SimpleDateFormat("MM/dd/yyyy").parse(rawBirthday);
            return new SimpleDateFormat("MM/dd/yyyy").format(parsedDate);
        } catch (Exception e) {
            return rawBirthday;
        }
    }


    private void applyCustomFont() {
        empFullName.setFont(CustomFont.getExtendedSemiBold(14f));
    }
    
    private String normalize(String input) {
        return input == null ? "" :
            input.trim()
                 .replaceAll(",", "")      // remove commas
                 .replaceAll("\\s+", " ")  // normalize spaces
                 .toLowerCase();
    }
    
    private void setEditMode(boolean editing) {
        // Define the only fields allowed to be edited in edit mode
        List<JTextField> editableFields = Arrays.asList(phoneNum);

        for (JTextField field : empInfoFieldList) {
            boolean isEditable = editing && editableFields.contains(field);
            field.setEditable(isEditable);
            field.setFocusable(isEditable);
            field.setCursor(new Cursor(isEditable ? Cursor.TEXT_CURSOR : Cursor.DEFAULT_CURSOR));
            field.setBackground(isEditable ? Color.WHITE : new Color(240, 240, 240));
        }

        // Birthday (formatted field)
        birthday.setEditable(editing);
        birthday.setFocusable(editing);
        birthday.setCursor(new Cursor(editing ? Cursor.TEXT_CURSOR : Cursor.DEFAULT_CURSOR));
        birthday.setBackground(editing ? Color.WHITE : new Color(240, 240, 240));

        // Address (text area)
        address2.setEditable(editing);
        address2.setFocusable(editing);
        address2.setCursor(new Cursor(editing ? Cursor.TEXT_CURSOR : Cursor.DEFAULT_CURSOR));
        address2.setBackground(editing ? Color.WHITE : new Color(240, 240, 240));

        // ComboBoxes always disabled
        empStatus.setEnabled(false);
        empPosition.setEnabled(false);
        empSupervisor.setEnabled(false);

        // Toggle buttons
        saveEmpButton.setVisible(editing);
        cancelEmpButton.setVisible(editing);
        editEmpButton.setVisible(!editing);
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
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
        firstName = new javax.swing.JTextField();
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
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        birthday = new javax.swing.JFormattedTextField();
        empStatus = new javax.swing.JComboBox<>();
        empPosition = new javax.swing.JComboBox<>();
        empSupervisor = new javax.swing.JComboBox<>();
        address1 = new javax.swing.JScrollPane();
        address2 = new javax.swing.JTextArea();
        saveEmpButton = new javax.swing.JButton();
        editEmpButton = new javax.swing.JButton();
        cancelEmpButton = new javax.swing.JButton();

        setMaximumSize(null);
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1000, 485));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1054, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1054, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1054, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        empFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empFullName.setText("Fist Name Last Name");
        jPanel1.add(empFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 31, -1, -1));

        jLabel3.setText("Employee Number:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 110, -1));

        empNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNumActionPerformed(evt);
            }
        });
        jPanel1.add(empNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 85, 341, -1));

        jLabel4.setText("First Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 116, 110, -1));

        jLabel5.setText("Last Name:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 144, 110, -1));

        jLabel6.setText("Date of Birth:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 172, 110, -1));

        jLabel7.setText("Address:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 200, 110, -1));

        jLabel8.setText("Phone Number:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, -1));

        lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameActionPerformed(evt);
            }
        });
        jPanel1.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 141, 341, -1));

        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });
        jPanel1.add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 113, 341, -1));

        phoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumActionPerformed(evt);
            }
        });
        jPanel1.add(phoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 341, -1));

        jLabel9.setText("SSS:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 289, 110, -1));

        jLabel10.setText("PhilHealth:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 317, 110, -1));

        jLabel11.setText("TIN:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 345, 110, -1));

        jLabel12.setText("Pag-IBIG:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 373, 110, -1));

        sssNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sssNumActionPerformed(evt);
            }
        });
        jPanel1.add(sssNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 286, 197, -1));

        philHealthNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                philHealthNumActionPerformed(evt);
            }
        });
        jPanel1.add(philHealthNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 314, 197, -1));

        tinNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinNumActionPerformed(evt);
            }
        });
        jPanel1.add(tinNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 342, 197, -1));

        pagIbigNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagIbigNumActionPerformed(evt);
            }
        });
        jPanel1.add(pagIbigNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 370, 197, -1));

        jLabel13.setText("Status:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 88, 110, -1));

        jLabel14.setText("Position:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 116, 110, -1));

        jLabel15.setText("Supervisor:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 144, 110, -1));

        jLabel16.setText("Basic Sallary:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 172, 110, -1));

        jLabel17.setText("Rice Subsidy:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 200, 110, -1));

        jLabel18.setText("Phone Allowance:");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 228, 110, -1));

        jLabel19.setText("Clothing Allowance:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 256, 110, -1));

        jLabel20.setText("Hourly Rate:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 312, 110, -1));

        empBasicSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empBasicSalaryActionPerformed(evt);
            }
        });
        jPanel1.add(empBasicSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 169, 219, -1));

        empRiceSubsidy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empRiceSubsidyActionPerformed(evt);
            }
        });
        jPanel1.add(empRiceSubsidy, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 197, 219, -1));

        empPhoneAllwc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empPhoneAllwcActionPerformed(evt);
            }
        });
        jPanel1.add(empPhoneAllwc, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 225, 219, -1));

        empClothingAllwc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empClothingAllwcActionPerformed(evt);
            }
        });
        jPanel1.add(empClothingAllwc, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 253, 219, -1));

        empSemiMonthlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empSemiMonthlyRateActionPerformed(evt);
            }
        });
        jPanel1.add(empSemiMonthlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 281, 219, -1));

        empHourlyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empHourlyRateActionPerformed(evt);
            }
        });
        jPanel1.add(empHourlyRate, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 309, 219, -1));

        jLabel21.setText("Semi-Monthly Rate:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(563, 284, 110, -1));

        birthday.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("MM/dd/yyyy"))));
        jPanel1.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 169, 341, -1));

        empStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status", "Probationary", "Regular" }));
        empStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empStatusActionPerformed(evt);
            }
        });
        jPanel1.add(empStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 85, 219, -1));

        empPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Position", "Chief Executive Officer", "Chief Finance Officer", "IT Operations and Systems", "HR Manager", "HR Rank and File", "Accounting Head", "Payroll Manager", "Payroll Team Leader", "Payroll Rank and File", "Account Manager", "Account Team Leader", "Account Rank and File", "Sales & Marketing", "Supply Chain and Logistics", "Customer Service and Relations" }));
        empPosition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empPositionActionPerformed(evt);
            }
        });
        jPanel1.add(empPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 113, 219, -1));

        empSupervisor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Supervisor", "Garcia, Manuel III", "Lim, Antonio", "Villanueva, Andrea Mae", "San, Jose Brad", "Aquino, Bianca Sofia", "Alvaro, Roderick", "Salcedo Anthony", "Romualdez, Fredrick", "Mata, Christian", "De Leon, Selena", "Reyes, Isabella" }));
        empSupervisor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empSupervisorActionPerformed(evt);
            }
        });
        jPanel1.add(empSupervisor, new org.netbeans.lib.awtextra.AbsoluteConstraints(679, 141, 219, -1));

        address1.setBackground(new java.awt.Color(255, 255, 255));
        address1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        address1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        address2.setEditable(false);
        address2.setBackground(new java.awt.Color(255, 255, 255));
        address2.setColumns(2);
        address2.setLineWrap(true);
        address2.setRows(5);
        address2.setWrapStyleWord(true);
        address1.setViewportView(address2);

        jPanel1.add(address1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 340, 40));

        saveEmpButton.setBackground(new java.awt.Color(0, 153, 0));
        saveEmpButton.setForeground(new java.awt.Color(255, 255, 255));
        saveEmpButton.setText("Save");
        saveEmpButton.setBorder(null);
        saveEmpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveEmpButtonActionPerformed(evt);
            }
        });
        jPanel1.add(saveEmpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 410, 90, 30));

        editEmpButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Blue"));
        editEmpButton.setForeground(new java.awt.Color(255, 255, 255));
        editEmpButton.setText("Edit");
        editEmpButton.setBorder(null);
        editEmpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEmpButtonActionPerformed(evt);
            }
        });
        jPanel1.add(editEmpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(817, 410, 90, 30));

        cancelEmpButton.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Grey"));
        cancelEmpButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelEmpButton.setText("Cancel");
        cancelEmpButton.setBorder(null);
        cancelEmpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEmpButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelEmpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(715, 410, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void saveEmpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveEmpButtonActionPerformed
        String id = empNum.getText().trim();

        List<EmployeeDetails> employees = DataHandler.readEmployeeDetails();
        for (EmployeeDetails emp : employees) {
            if (emp.getEmployeeId().equals(id)) {
                emp.setFirstName(firstName.getText().trim());
                emp.setLastName(lastName.getText().trim());
                emp.setBirthday(birthday.getText().trim());
                emp.setAddress(address2.getText().trim());
                emp.setPhoneNumber(phoneNum.getText().trim());
                break;
            }
        }

        DataHandler.writeEmployeeData(employees);
        JOptionPane.showMessageDialog(this, "✅ Profile updated successfully.");
        setEditMode(false);
    }//GEN-LAST:event_saveEmpButtonActionPerformed

    private void editEmpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEmpButtonActionPerformed
        setEditMode(true);
    }//GEN-LAST:event_editEmpButtonActionPerformed

    private void cancelEmpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEmpButtonActionPerformed
        loadEmployeeDetailsByFullName(empFullName.getText()); // reload original
        setEditMode(false);
    }//GEN-LAST:event_cancelEmpButtonActionPerformed

    private void empNumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empNumActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empNumActionPerformed

    private void lastNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_lastNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_lastNameActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_firstNameActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_addressActionPerformed

    private void phoneNumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_phoneNumActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_phoneNumActionPerformed

    private void sssNumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_sssNumActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_sssNumActionPerformed

    private void philHealthNumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_philHealthNumActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_philHealthNumActionPerformed

    private void tinNumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tinNumActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tinNumActionPerformed

    private void pagIbigNumActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_pagIbigNumActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_pagIbigNumActionPerformed

    private void empBasicSalaryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empBasicSalaryActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empBasicSalaryActionPerformed

    private void empRiceSubsidyActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empRiceSubsidyActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empRiceSubsidyActionPerformed

    private void empPhoneAllwcActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empPhoneAllwcActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empPhoneAllwcActionPerformed

    private void empClothingAllwcActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empClothingAllwcActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empClothingAllwcActionPerformed

    private void empSemiMonthlyRateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empSemiMonthlyRateActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empSemiMonthlyRateActionPerformed

    private void empHourlyRateActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empHourlyRateActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empHourlyRateActionPerformed

    private void empStatusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empStatusActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empStatusActionPerformed

    private void empPositionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empPositionActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empPositionActionPerformed

    private void empSupervisorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empSupervisorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_empSupervisorActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane address1;
    private javax.swing.JTextArea address2;
    private javax.swing.JFormattedTextField birthday;
    private javax.swing.JButton cancelEmpButton;
    private javax.swing.JButton editEmpButton;
    private javax.swing.JTextField empBasicSalary;
    private javax.swing.JTextField empClothingAllwc;
    private javax.swing.JLabel empFullName;
    private javax.swing.JTextField empHourlyRate;
    private javax.swing.JTextField empNum;
    private javax.swing.JTextField empPhoneAllwc;
    private javax.swing.JComboBox<String> empPosition;
    private javax.swing.JTextField empRiceSubsidy;
    private javax.swing.JTextField empSemiMonthlyRate;
    private javax.swing.JComboBox<String> empStatus;
    private javax.swing.JComboBox<String> empSupervisor;
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
    private javax.swing.JButton saveEmpButton;
    private javax.swing.JTextField sssNum;
    private javax.swing.JTextField tinNum;
    // End of variables declaration//GEN-END:variables
}

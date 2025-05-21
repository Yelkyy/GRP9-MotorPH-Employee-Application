package motorph.ui.components;


import motorph.model.EmployeeDetails;
import motorph.repository.DataHandler;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class EmployeePanel extends javax.swing.JPanel {
    
    
    
    public EmployeePanel(String name) {
        initComponents();
        jLabel1.setText(name);
        loadEmployeesToTable();
      
    }
    
    public void loadEmployeesToTable() {
        List<EmployeeDetails> employees = DataHandler.readEmployeeDetails();
        DefaultTableModel model = (DefaultTableModel) employeeListTable.getModel();
        model.setRowCount(0);
        
        for (EmployeeDetails emp : employees) {
            model.addRow(new Object[]{
                emp.getEmployeeNumber(),
                emp.getLastName(),
                emp.getFirstName(),               
                emp.getSssNumber(),
                emp.getPhilhealthNumber(),
                emp.getTinNumber(),
                emp.getPagIbigNumber()                
            });
        }
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeListTable = new javax.swing.JTable();
        searchButton = new javax.swing.JButton();
        searchBar = new javax.swing.JTextField();

        setBackground(new java.awt.Color(245, 245, 245));
        setMaximumSize(new java.awt.Dimension(1054, 720));
        setMinimumSize(new java.awt.Dimension(1054, 720));
        setPreferredSize(new java.awt.Dimension(1054, 720));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(139, 139, 139));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("EMPLOYEE PANEL");

        employeeListTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        employeeListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Employee #", "Last Name", "First Name", "SSS #", "PhilHealth #", "TIN #", "Pag-IBIG #"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(employeeListTable);
        if (employeeListTable.getColumnModel().getColumnCount() > 0) {
            employeeListTable.getColumnModel().getColumn(0).setResizable(false);
            employeeListTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            employeeListTable.getColumnModel().getColumn(1).setResizable(false);
            employeeListTable.getColumnModel().getColumn(2).setResizable(false);
            employeeListTable.getColumnModel().getColumn(3).setResizable(false);
            employeeListTable.getColumnModel().getColumn(4).setResizable(false);
            employeeListTable.getColumnModel().getColumn(5).setResizable(false);
            employeeListTable.getColumnModel().getColumn(6).setResizable(false);
        }

        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/motorph/icons/search.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        searchBar.setForeground(new java.awt.Color(153, 153, 153));
        searchBar.setText("Search Employee by ID");
        searchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(searchButton)
                        .addGap(2, 2, 2)))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(searchBar))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
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
        // TODO add your handling code here: (Action listener for the search button)
        // Retrieve the search input (employee ID)
        String empNumber = searchBar.getText().trim();

        // Check if the input is empty
        if (empNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an Employee ID.");
            return;
        }

        // Load employee data from the DataHandler (or any data source you're using)
        List<EmployeeDetails> employees = DataHandler.readEmployeeDetails();
        DefaultTableModel model = (DefaultTableModel) employeeListTable.getModel();
        model.setRowCount(0); // Clear the existing table rows before adding search results

        boolean found = false;

        // Loop through the employees and find the one that matches the entered employee ID
        for (EmployeeDetails emp : employees) {
            if (String.valueOf(emp.getEmployeeNumber()).equals(empNumber)) {
                model.addRow(new Object[]{
                    emp.getEmployeeNumber(),
                    emp.getLastName(),
                    emp.getFirstName(),
                    emp.getSssNumber(),
                    emp.getPhilhealthNumber(),
                    emp.getTinNumber(),
                    emp.getPagIbigNumber()
                });
                found = true;
                break; // Stop searching once the employee is found
            }
        }

        // If no employee is found with the given ID
        if (!found) {
            JOptionPane.showMessageDialog(this, "Employee not found.");
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchBarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable employeeListTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchBar;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}

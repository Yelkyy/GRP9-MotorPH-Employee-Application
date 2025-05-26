package motorph.ui.components;

import javax.swing.JFrame;
import javax.swing.JDialog;
import motorph.model.EmployeeDetails;


public class DisplayEmployeeInfo extends javax.swing.JDialog {

    public DisplayEmployeeInfo(JFrame parent) {
        super(parent, "Employee Info", true);

        initComponents();
        this.setLocationRelativeTo(parent);       
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Employee Info");
        setMaximumSize(new java.awt.Dimension(1054, 720));
        setMinimumSize(new java.awt.Dimension(1054, 720));
        setName("displayEmpFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1054, 720));
        setResizable(false);

        jPanel1.setMaximumSize(new java.awt.Dimension(1054, 720));
        jPanel1.setMinimumSize(new java.awt.Dimension(1054, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1054, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Employee details are temporarily unavailable due to ongoing maintenance.");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel1)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel1)
                .addContainerGap(394, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

package motorph.ui.employeeRole;


import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import motorph.model.User;
import motorph.ui.components.MyRender;

//Employee Dashboard
public class Dashboard extends javax.swing.JFrame {
    private static JPanel mainBody;
    private User currentUser;
    private JButton selectedButton;
   
    public Dashboard(User user) {
        this.currentUser = user;
        initComponents();
        setLocationRelativeTo(null);

        mainBody = body;
        setupNavButtons();     
        showPanel(new Overview(currentUser.getFullName()));
        setActiveButton(overviewBttn);  
    }
        
    private void setupNavButtons() {
        MyRender.applyButtonStyle(overviewBttn, true);
        MyRender.applyButtonStyle(myProfileBttn, false);
        MyRender.applyButtonStyle(attendanceBttn, false);
        MyRender.applyButtonStyle(leavesBttn, false);
        MyRender.applyButtonStyle(payrollBttn, false);

        logoutBttn.setText(currentUser.getFullName());

        navBar2.removeAll();
        navBar2.add(overviewBttn);
        navBar2.add(myProfileBttn);
        navBar2.add(attendanceBttn);
        navBar2.add(leavesBttn);
        navBar2.add(payrollBttn);
        navBar2.revalidate();
        navBar2.repaint();
    }


    
    public static void showPanel(JPanel panel){
        mainBody.removeAll(); 
        mainBody.add(panel);
        mainBody.revalidate();
        mainBody.repaint();
    }
    
    private void setActiveButton(JButton activeButton) {
        if (selectedButton != null) {
            MyRender.applyButtonStyle(selectedButton, false); // Reset previous button style
        }
        MyRender.applyButtonStyle(activeButton, true); // Highlight new active button
        selectedButton = activeButton; // Update tracker
    }


        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        navBar = new javax.swing.JPanel();
        motorphLogo = new javax.swing.JLabel();
        logoutBttn = new javax.swing.JButton();
        navBar2 = new javax.swing.JPanel();
        overviewBttn = new javax.swing.JButton();
        myProfileBttn = new javax.swing.JButton();
        attendanceBttn = new javax.swing.JButton();
        leavesBttn = new javax.swing.JButton();
        payrollBttn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        body.setBackground(new java.awt.Color(255, 255, 255));
        body.setPreferredSize(new java.awt.Dimension(1000, 485));
        body.setLayout(new java.awt.CardLayout());
        getContentPane().add(body, java.awt.BorderLayout.CENTER);

        navBar.setBackground(new java.awt.Color(255, 255, 255));

        motorphLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/motorph/icons/Group 222 (2).png"))); // NOI18N

        logoutBttn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/motorph/icons/user-circle.png"))); // NOI18N
        logoutBttn.setText("FirstName LastName");
        logoutBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBttnActionPerformed(evt);
            }
        });

        navBar2.setBackground(new java.awt.Color(255, 255, 255));
        navBar2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 80, 10);
        flowLayout1.setAlignOnBaseline(true);
        navBar2.setLayout(flowLayout1);

        overviewBttn.setText("Overview");
        overviewBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                overviewBttnActionPerformed(evt);
            }
        });
        navBar2.add(overviewBttn);

        myProfileBttn.setText("My Profle");
        myProfileBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myProfileBttnActionPerformed(evt);
            }
        });
        navBar2.add(myProfileBttn);

        attendanceBttn.setText("Attendance");
        attendanceBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                attendanceBttnActionPerformed(evt);
            }
        });
        navBar2.add(attendanceBttn);

        leavesBttn.setText("Leaves");
        leavesBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leavesBttnActionPerformed(evt);
            }
        });
        navBar2.add(leavesBttn);

        payrollBttn.setText("Payroll");
        payrollBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payrollBttnActionPerformed(evt);
            }
        });
        navBar2.add(payrollBttn);

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
            .addGroup(navBarLayout.createSequentialGroup()
                .addComponent(motorphLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBttn)
                .addContainerGap())
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navBarLayout.createSequentialGroup()
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(navBarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(motorphLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(navBarLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(logoutBttn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(navBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(navBar, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void overviewBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_overviewBttnActionPerformed
        setActiveButton(overviewBttn);
        showPanel(new Overview(currentUser.getFullName()));
    }//GEN-LAST:event_overviewBttnActionPerformed

    private void myProfileBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myProfileBttnActionPerformed
        setActiveButton(myProfileBttn);
        showPanel(new MyProfile(currentUser));
    }//GEN-LAST:event_myProfileBttnActionPerformed

    private void attendanceBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_attendanceBttnActionPerformed
        setActiveButton(attendanceBttn);
        showPanel(new EmployeeAttendance(currentUser));
    }//GEN-LAST:event_attendanceBttnActionPerformed

    private void leavesBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leavesBttnActionPerformed
        setActiveButton(leavesBttn);
        showPanel(new Leave(currentUser));
    }//GEN-LAST:event_leavesBttnActionPerformed

    private void payrollBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payrollBttnActionPerformed
        setActiveButton(payrollBttn);
        showPanel(new EmployeePayruns(currentUser));
    }//GEN-LAST:event_payrollBttnActionPerformed

    private void logoutBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBttnActionPerformed
        JPopupMenu menu = new JPopupMenu();
        JMenuItem logoutItem = new JMenuItem("Logout");
        
        logoutItem.setPreferredSize(new java.awt.Dimension(logoutBttn.getWidth(), logoutItem.getPreferredSize().height));

        logoutItem.addActionListener(e -> {
            this.dispose();
            new motorph.ui.LoginScreen().setVisible(true);
        });

        menu.add(logoutItem);
        menu.show(logoutBttn, 0, logoutBttn.getHeight());
    }//GEN-LAST:event_logoutBttnActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton attendanceBttn;
    private javax.swing.JPanel body;
    private javax.swing.JButton leavesBttn;
    private javax.swing.JButton logoutBttn;
    private javax.swing.JLabel motorphLogo;
    private javax.swing.JButton myProfileBttn;
    private javax.swing.JPanel navBar;
    private javax.swing.JPanel navBar2;
    private javax.swing.JButton overviewBttn;
    private javax.swing.JButton payrollBttn;
    // End of variables declaration//GEN-END:variables
}

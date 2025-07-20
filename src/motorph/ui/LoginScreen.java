package motorph.ui;

import java.util.Map;
import javax.swing.JOptionPane;
import motorph.model.User;
import motorph.repository.DataHandler;
import motorph.utils.UserAuthentication;

public class LoginScreen extends javax.swing.JFrame {

    public LoginScreen() {
        initComponents();
        setLocationRelativeTo(null);

    }
    
    private void updateLoginButtonLabel() {
        String selectedLevel = (String) userLevelDd.getSelectedItem();
        if ("Admin".equalsIgnoreCase(selectedLevel)) {
            loginButton.setText("Login as Admin");
        } else if ("User".equalsIgnoreCase(selectedLevel)) {
            loginButton.setText("Login");
        } else {
            loginButton.setText("Login");
        }
    }


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        right = new javax.swing.JPanel();
        companylogo = new javax.swing.JLabel();
        left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();
        inputEmail = new javax.swing.JTextField();
        passwordLbl = new javax.swing.JLabel();
        inputPassword = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        showPWBox = new javax.swing.JCheckBox();
        userLevelLbl = new javax.swing.JLabel();
        userLevelDd = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOTORPH LOGIN");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName("loginFrame"); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setLayout(null);

        right.setBackground(new java.awt.Color(0, 66, 102));
        right.setMaximumSize(new java.awt.Dimension(400, 500));
        right.setMinimumSize(new java.awt.Dimension(400, 500));
        right.setName(""); // NOI18N
        right.setPreferredSize(new java.awt.Dimension(400, 500));

        companylogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/motorph/icons/logoResize.png"))); // NOI18N

        javax.swing.GroupLayout rightLayout = new javax.swing.GroupLayout(right);
        right.setLayout(rightLayout);
        rightLayout.setHorizontalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightLayout.createSequentialGroup()
                .addComponent(companylogo)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        rightLayout.setVerticalGroup(
            rightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightLayout.createSequentialGroup()
                .addComponent(companylogo, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        jPanel1.add(right);
        right.setBounds(0, 0, 400, 500);

        left.setBackground(new java.awt.Color(255, 255, 255));
        left.setMaximumSize(new java.awt.Dimension(400, 500));
        left.setMinimumSize(new java.awt.Dimension(400, 500));
        left.setPreferredSize(new java.awt.Dimension(400, 500));
        left.setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 66, 102));
        jLabel1.setText("LOGIN");

        userLbl.setBackground(new java.awt.Color(102, 102, 102));
        userLbl.setText("Username");

        inputEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputEmailActionPerformed(evt);
            }
        });

        passwordLbl.setBackground(new java.awt.Color(102, 102, 102));
        passwordLbl.setText("Password");

        inputPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPasswordActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(0, 66, 102));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginButtonKeyPressed(evt);
            }
        });

        showPWBox.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        showPWBox.setText("Show Password");
        showPWBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPWBoxActionPerformed(evt);
            }
        });

        userLevelLbl.setBackground(new java.awt.Color(102, 102, 102));
        userLevelLbl.setText("User level");

        userLevelDd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Admin", "User" }));
        userLevelDd.setMaximumSize(null);
        userLevelDd.setMinimumSize(null);
        userLevelDd.setPreferredSize(new java.awt.Dimension(64, 22));
        userLevelDd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userLevelDdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftLayout = new javax.swing.GroupLayout(left);
        left.setLayout(leftLayout);
        leftLayout.setHorizontalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userLevelLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPWBox, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputEmail)
                    .addComponent(inputPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(userLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userLevelDd, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftLayout.setVerticalGroup(
            leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(userLevelLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userLevelDd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(userLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPWBox)
                .addGap(37, 37, 37)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jPanel1.add(left);
        left.setBounds(410, 0, 390, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("LOGIN");
        getAccessibleContext().setAccessibleParent(this);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputEmailActionPerformed
        loginButtonActionPerformed(null);
    }//GEN-LAST:event_inputEmailActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String email = inputEmail.getText().trim();
        String password = new String(inputPassword.getPassword()).trim();
        String selectedLevel = (String) userLevelDd.getSelectedItem();

        if (selectedLevel.equals("None")) {
            JOptionPane.showMessageDialog(this, "Please select a valid user level.",
                    "User Level Required", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        User user = UserAuthentication.authenticate(email, password);

        if (user != null) {
            // Check if user role matches the selected user level
            boolean isValid = false;

            if ("Admin".equalsIgnoreCase(selectedLevel) && user.isAdmin()) {
                isValid = true;
            } else if ("User".equalsIgnoreCase(selectedLevel) && (user.isHR() || user.isEmployee())) {
                isValid = true;
            }

            if (!isValid) {
                JOptionPane.showMessageDialog(this,
                        "User level mismatch",
                        "Login Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Launch appropriate dashboard
            if (user.isAdmin()) {
                motorph.ui.Dashboard dashboardFrame = new motorph.ui.Dashboard(); 
                dashboardFrame.personalize(user.getFullName());
                dashboardFrame.setVisible(true);
            } else if (user.isHR()) {
                motorph.ui.Dashboard dashboardFrame = new motorph.ui.Dashboard();
                dashboardFrame.personalize(user.getFullName());
                dashboardFrame.setVisible(true);
            } else if (user.isEmployee()) {
                motorph.ui.employeeRole.Dashboard empDash = new motorph.ui.employeeRole.Dashboard(user);
                empDash.setVisible(true);
            }

            this.dispose(); // Close login screen

        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.",
                    "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginButtonKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            loginButtonActionPerformed(null);
        }
    }//GEN-LAST:event_loginButtonKeyPressed

    private void inputPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPasswordActionPerformed
        loginButtonActionPerformed(null);
    }//GEN-LAST:event_inputPasswordActionPerformed

    private void showPWBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPWBoxActionPerformed
        if (showPWBox.isSelected()) {
            inputPassword.setEchoChar((char) 0);
            } else {
            inputPassword.setEchoChar('•');
        }
    }//GEN-LAST:event_showPWBoxActionPerformed

    private void userLevelDdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userLevelDdActionPerformed
        updateLoginButtonLabel();
    }//GEN-LAST:event_userLevelDdActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel companylogo;
    private javax.swing.JTextField inputEmail;
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel left;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JPanel right;
    private javax.swing.JCheckBox showPWBox;
    private javax.swing.JLabel userLbl;
    private javax.swing.JComboBox<String> userLevelDd;
    private javax.swing.JLabel userLevelLbl;
    // End of variables declaration//GEN-END:variables
}

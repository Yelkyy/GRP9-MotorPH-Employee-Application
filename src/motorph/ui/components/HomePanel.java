package motorph.ui.components;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;
/**
 * HomePanel serves as the default landing panel in the MotorPH dashboard.
 * It displays the current pay period dynamically based on the system date
 * and includes a calendar widget.
 */
public class HomePanel extends javax.swing.JPanel {
    
    private Font neuePlakFont;
    
     /**
     * Constructs the HomePanel and initializes its components.
     */  
    public HomePanel() {
        loadCustomFont();
        initComponents();
        applyCustomFont();
        
    }
    
    private void loadCustomFont() {
        try {
            InputStream is = getClass().getResourceAsStream("/fonts/NeuePlakExtendedRegular.ttf");
            if (is != null) {
                neuePlakFont = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(24f);
                GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(neuePlakFont);
            } else {
                System.err.println("Font file not found in /fonts/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void applyCustomFont() {
        if (neuePlakFont != null) {
            header.setFont(neuePlakFont.deriveFont(28f)); // Dashboard Overview
            welcomeHeader.setFont(neuePlakFont.deriveFont(16f)); // Welcome message
        }
    }
    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boarder1 = new javax.swing.JSeparator();
        header = new javax.swing.JLabel();
        welcomeHeader = new javax.swing.JLabel();
        totalEmpBox = new motorph.ui.components.RoundedPanel(40);
        totalEmpText = new javax.swing.JLabel();
        totalEmpNum = new javax.swing.JLabel();
        payPeriodBox = new motorph.ui.components.RoundedPanel(40);
        payPeriodTxt = new javax.swing.JLabel();
        payPeriodNum = new javax.swing.JLabel();
        todayLeaveBox2 = new motorph.ui.components.RoundedPanel(40);
        totalEmpText2 = new javax.swing.JLabel();
        todayLeaveNum2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1054, 720));
        setMinimumSize(new java.awt.Dimension(1054, 720));

        boarder1.setBackground(new java.awt.Color(0, 66, 102));
        boarder1.setForeground(new java.awt.Color(0, 66, 102));

        header.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        header.setText("Dashboard Overview");

        welcomeHeader.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        welcomeHeader.setText("Welcome back, Admin!");

        totalEmpBox.setBackground(new java.awt.Color(150, 170, 252));
        totalEmpBox.setForeground(new java.awt.Color(255, 255, 255));
        totalEmpBox.setMaximumSize(new java.awt.Dimension(230, 130));
        totalEmpBox.setMinimumSize(new java.awt.Dimension(230, 130));

        totalEmpText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalEmpText.setText("Total Employees");

        totalEmpNum.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        totalEmpNum.setText("35");

        javax.swing.GroupLayout totalEmpBoxLayout = new javax.swing.GroupLayout(totalEmpBox);
        totalEmpBox.setLayout(totalEmpBoxLayout);
        totalEmpBoxLayout.setHorizontalGroup(
            totalEmpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalEmpBoxLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(totalEmpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalEmpNum)
                    .addComponent(totalEmpText))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        totalEmpBoxLayout.setVerticalGroup(
            totalEmpBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalEmpBoxLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(totalEmpText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalEmpNum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        payPeriodBox.setBackground(new java.awt.Color(255, 153, 153));
        payPeriodBox.setForeground(new java.awt.Color(255, 255, 255));
        payPeriodBox.setMaximumSize(new java.awt.Dimension(230, 130));
        payPeriodBox.setMinimumSize(new java.awt.Dimension(230, 130));
        payPeriodBox.setPreferredSize(new java.awt.Dimension(230, 130));

        payPeriodTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        payPeriodTxt.setText("Payroll Period");

        payPeriodNum.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        payPeriodNum.setText("May 16 - May 31, 2025");

        javax.swing.GroupLayout payPeriodBoxLayout = new javax.swing.GroupLayout(payPeriodBox);
        payPeriodBox.setLayout(payPeriodBoxLayout);
        payPeriodBoxLayout.setHorizontalGroup(
            payPeriodBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payPeriodBoxLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(payPeriodBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(payPeriodNum, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addGroup(payPeriodBoxLayout.createSequentialGroup()
                        .addComponent(payPeriodTxt)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        payPeriodBoxLayout.setVerticalGroup(
            payPeriodBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(payPeriodBoxLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(payPeriodTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(payPeriodNum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        todayLeaveBox2.setBackground(new java.awt.Color(255, 153, 255));
        todayLeaveBox2.setForeground(new java.awt.Color(255, 255, 255));
        todayLeaveBox2.setMaximumSize(new java.awt.Dimension(230, 130));
        todayLeaveBox2.setMinimumSize(new java.awt.Dimension(230, 130));
        todayLeaveBox2.setPreferredSize(new java.awt.Dimension(230, 130));

        totalEmpText2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        totalEmpText2.setText("Today Leave");

        todayLeaveNum2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        todayLeaveNum2.setText("1");

        javax.swing.GroupLayout todayLeaveBox2Layout = new javax.swing.GroupLayout(todayLeaveBox2);
        todayLeaveBox2.setLayout(todayLeaveBox2Layout);
        todayLeaveBox2Layout.setHorizontalGroup(
            todayLeaveBox2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todayLeaveBox2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(todayLeaveBox2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(todayLeaveNum2)
                    .addComponent(totalEmpText2))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        todayLeaveBox2Layout.setVerticalGroup(
            todayLeaveBox2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(todayLeaveBox2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(totalEmpText2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(todayLeaveNum2)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boarder1)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(welcomeHeader)
                    .addComponent(header))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addComponent(totalEmpBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(todayLeaveBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(payPeriodBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(welcomeHeader)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(header)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boarder1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(payPeriodBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(todayLeaveBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalEmpBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(460, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Dynamically sets the current pay period label based on today's date.
     * Pay periods are 1st–15th and 16th–end of the month.
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator boarder1;
    private javax.swing.JLabel header;
    private javax.swing.JPanel payPeriodBox;
    private javax.swing.JLabel payPeriodNum;
    private javax.swing.JLabel payPeriodTxt;
    private javax.swing.JPanel todayLeaveBox2;
    private javax.swing.JLabel todayLeaveNum2;
    private javax.swing.JPanel totalEmpBox;
    private javax.swing.JLabel totalEmpNum;
    private javax.swing.JLabel totalEmpText;
    private javax.swing.JLabel totalEmpText2;
    private javax.swing.JLabel welcomeHeader;
    // End of variables declaration//GEN-END:variables
}

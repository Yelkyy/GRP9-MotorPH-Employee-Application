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
        initComponents(); // Automatically set label on panel load
        applyCustomFont();
        updatePayPeriodLabel();
        
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
            jLabel2.setFont(neuePlakFont.deriveFont(28f)); // Dashboard Overview
            jLabel3.setFont(neuePlakFont.deriveFont(16f)); // Welcome message
        }
    }
    
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        boarder1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1054, 720));
        setMinimumSize(new java.awt.Dimension(1054, 720));

        jCalendar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 66, 102)));
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Current Pay Period: May 16, 2025 - May 31, 2025");

        boarder1.setBackground(new java.awt.Color(0, 66, 102));
        boarder1.setForeground(new java.awt.Color(0, 66, 102));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Dashboard Overview");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Welcome back, Admin!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(boarder1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(290, 640, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boarder1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Dynamically sets the current pay period label based on today's date.
     * Pay periods are 1st–15th and 16th–end of the month.
     */
    private void updatePayPeriodLabel() {
        java.time.LocalDate today = java.time.LocalDate.now();
        int day = today.getDayOfMonth();
        java.time.Month month = today.getMonth();
        int year = today.getYear();

        String payPeriod;

        if (day <= 15) {
            payPeriod = String.format("Current Pay Period: %s 1, %d - %s 15, %d",
                    month, year, month, year);
        } else {
            int lastDay = month.length(java.time.Year.isLeap(year));
            payPeriod = String.format("Current Pay Period: %s 16, %d - %s %d, %d",
                    month, year, month, lastDay, year);
        }

        jLabel1.setText(payPeriod);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator boarder1;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}

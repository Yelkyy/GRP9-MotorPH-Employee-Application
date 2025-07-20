package motorph.ui.employeeRole;


import motorph.model.User;
import motorph.ui.components.CustomFont;

//Homepanel for Employee
public class Overview extends javax.swing.JPanel {  


    public Overview(String firstName) {
        initComponents();
        applyCustomFont();

        
        welcomeMsg.setText("Hello " + firstName + "!");
        greetings.setText(getGreeting());
    }
    
    private void applyCustomFont() {
        greetings.setFont(CustomFont.getExtendedSemiBold(28f));
        welcomeMsg.setFont(CustomFont.getExtendedRegular(16f));
        
    }
    
     private String getGreeting() {
        int hour = java.time.LocalTime.now().getHour();
        if (hour < 12) return "Good Morning";
        if (hour < 18) return "Good Afternoon";
        return "Good Evening";
    }
            
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeMsg = new javax.swing.JLabel();
        greetings = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(1000, 485));

        welcomeMsg.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        welcomeMsg.setText("Hello (Name)!");

        greetings.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        greetings.setText("Good Morning");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(greetings)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(welcomeMsg)))
                .addContainerGap(822, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(welcomeMsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(greetings)
                .addContainerGap(397, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel greetings;
    private javax.swing.JLabel welcomeMsg;
    // End of variables declaration//GEN-END:variables
}

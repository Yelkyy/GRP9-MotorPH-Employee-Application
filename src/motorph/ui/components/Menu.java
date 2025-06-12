package motorph.ui.components;

import motorph.ui.Payroll;
import motorph.ui.HomePanel;
import motorph.ui.Attendance;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import motorph.ui.Dashboard;
import motorph.ui.EmployeePanel;
import net.miginfocom.swing.MigLayout;

/**
 * Menu component for the MotorPH Dashboard.
 * Dynamically generates main and sub-menu items and handles panel switching within the UI.
 */
public class Menu extends JComponent {

    private MigLayout layout;
    private JPanel mainPanel;

    /**
     * Allows the Dashboard to inject the main display panel (body) for content swapping.
     * @param panel the body panel of the Dashboard where dynamic content is rendered
     */
    public void setMainPanel(JPanel panel) {
        this.mainPanel = panel;
    }

    // Menu structure: {Main Menu, SubItem1, SubItem2...}
    private String[][] menuItems = new String[][] {
            { "Dashboard" },
            { "Employee" },
            { "Attendance" },
            { "Payroll" },
            
            
    };
    
    /**
     * Constructs the Menu and initializes layout and items.
     */
    public Menu() {
        init();
    }
    
    /**
     * Initializes the menu layout and populates it with menu items.
     */
    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);

        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }

    }
    /**
     * Adds a main menu item and optionally links its sub-items.
     *
     * @param menuName the name of the main menu item
     * @param index the index in the menuItems array
     */
    private void addMenu(String menuName, int index) {
        MenuItem item = new MenuItem(menuName, index);

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel != null) {
                    mainPanel.removeAll();

                    switch (menuName) {
                        case "Dashboard":
                            mainPanel.add(new HomePanel());
                            break;
                        case "Employee":
                            mainPanel.add(new EmployeePanel("Employee List"));
                            break;
                        case "Attendance":
                            mainPanel.add(new Attendance());
                            break;
                        case "Payroll":
                            mainPanel.add(new Payroll());
                            break;
                    }

                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
            }
        });

        add(item);
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(0, 66, 102));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }
}

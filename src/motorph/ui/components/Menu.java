package motorph.ui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import motorph.ui.Dashboard;
import motorph.ui.components.EmployeePanel;
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
            { "Employee", "Employee List", "Add Employee" },
            { "Payroll", "View Payroll" },
            
            
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
        int length = menuItems[index].length;
        MenuItem item = new MenuItem(menuName, index, length > 1);

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (length > 1) {
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    } else {
                        hideMenu(item, index);
                        item.setSelected(false);
                    }
                } else {
                    if ("Dashboard".equals(menuName)) {
                    if (mainPanel != null) {
                        mainPanel.removeAll();
                        mainPanel.add(new HomePanel());
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                    }
                }
            }
        });

        // Add main menu item to the layout
        add(item);
        revalidate();
        repaint();
    }
    /**
     * Adds sub-menu items under a main menu item.
     *
     * @param item the parent MenuItem
     * @param index index of the parent in menuItems
     * @param length number of submenu items
     * @param indexZorder index to insert the submenu panel at
     */
    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill"));
        panel.setName(index + "");
        panel.setOpaque(false); // Transparent background
        
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuItems[index][i], i, false);
            subItem.initSubMenu(i, length);
            panel.add(subItem);
            panel.setBackground(UIManager.getColor("PopupMenu.background"));

            // here ill add a click event
            subItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle "Employee List" click
                    if (subItem.getText().equals("Employee List")) {
                        // Set the EmployeePanel as the new content for the main body
                        mainPanel.removeAll();
                        mainPanel.add(new EmployeePanel("Employee List"));
                        mainPanel.revalidate();
                        mainPanel.repaint();
                    }
                    // Additional submenu cases can be added here
                }
            }); 
        }
        
        add(panel, "h 0!", indexZorder + 1); // Start collapsed (0 height)
        revalidate();
        repaint();

        MenuAnimation.showMenu(panel, item, layout, true); // Animate showing the submenu panel
    }
    
    /**
     * Hides a submenu panel.
     *
     * @param item the main menu item
     * @param index index of the main menu item
     */
    private void hideMenu(MenuItem item, int index) {
        // create for loop to find the subMenu panel by index
        for (Component com : getComponents()) {
            if (com instanceof JPanel && com.getName() != null && com.getName().equals(index + "")) {
                com.setName(null); // Clear name to prevent duplicate processing
                MenuAnimation.showMenu(com, item, layout, false); // Animate hiding
                break;
            }
        }
    }
    
    /**
     * Paints the background of the menu component.
     */
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(0, 66, 102));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }

}

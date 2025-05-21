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
import motorph.ui.Dashboard;
import motorph.ui.components.EmployeePanel;
import net.miginfocom.swing.MigLayout;

public class Menu extends JComponent {

    private MigLayout layout;
    private JPanel mainPanel;

    // method thats allowing Dashboard to pass in the body panel
    public void setMainPanel(JPanel panel) {
        this.mainPanel = panel;
    }

    // Here is the main menu and their submenus
    private String[][] menuItems = new String[][] {
            { "Dashboard" },
            { "Employee", "Employee List", "Add Employee" },
            { "Payroll", "View Payroll" }
    };

    public Menu() {
        init(); // initializing the menu layout and items
    }

    private void init() {
        // Configure MigLayout: 1 column (wrap 1), fill horizontally, no vertical gap,
        // small inset
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill");
        setLayout(layout);
        setOpaque(true);

        for (int i = 0; i < menuItems.length; i++) {
            addMenu(menuItems[i][0], i);
        }

    }

    private void addMenu(String menuName, int index) {
        int length = menuItems[index].length;

        MenuItem item = new MenuItem(menuName, index, length > 1);

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (length > 1) {
                    // used condition by show the menu if menu item is not selected
                    if (!item.isSelected()) {
                        item.setSelected(true);
                        addSubMenu(item, index, length, getComponentZOrder(item));
                    } else {
                        // hide menu
                        hideMenu(item, index);
                        item.setSelected(false);
                    }

                }
            }
        });

        // Add main menu item to the layout
        add(item);
        revalidate();
        repaint();
    }

    private void addSubMenu(MenuItem item, int index, int length, int indexZorder) {
        // Panel to hold the submenu items
        JPanel panel = new JPanel(new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill"));
        panel.setName(index + ""); // Name the panel by its index to identify it later
        panel.setOpaque(false); // Transparent background

        // Add submenu items to the panel (skip the first item since it's the main menu)
        for (int i = 1; i < length; i++) {
            MenuItem subItem = new MenuItem(menuItems[index][i], i, false);
            subItem.initSubMenu(i, length);
            panel.add(subItem);

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
                }
            }); // ----------end.

        }
        // Initially set panel height to 0 (for animation)
        add(panel, "h 0!", indexZorder + 1); // set the panel height to 0 because I used animation to show
        revalidate();
        repaint();

        // Animate showing the submenu panel
        MenuAnimation.showMenu(panel, item, layout, true);
    }

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

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(0, 66, 102));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }

}

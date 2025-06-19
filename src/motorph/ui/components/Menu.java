package motorph.ui.components;

import motorph.ui.PayrollVer2;
import motorph.ui.HomePanel;
import motorph.ui.Attendance;
import motorph.model.MenuHandler;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import motorph.ui.Dashboard;
import motorph.ui.EmployeePanel;
import motorph.ui.PayrollVer2;
import net.miginfocom.swing.MigLayout;

/**
 * Menu component for the MotorPH Dashboard.
 * Dynamically generates main and sub-menu items and handles panel switching within the UI.
 */
public class Menu extends JComponent {

    private MigLayout layout;
    private JPanel mainPanel;
    private MenuItem selectedItem = null;

    /**
     * Allows the Dashboard to inject the main display panel (body) for content swapping.
     * @param panel the body panel of the Dashboard where dynamic content is rendered
     */
    public void setMainPanel(JPanel panel) {
        this.mainPanel = panel;
    }

    // Menu structure: {Main Menu, SubItem1, SubItem2...}
    private MenuHandler[] menuItems = new MenuHandler[] {
        new MenuHandler("0White", "Dashboard", MenuHandler.menuType.MENU),
        new MenuHandler("2White", "Employee", MenuHandler.menuType.MENU),
        new MenuHandler("3White", "Attendance", MenuHandler.menuType.MENU),
        new MenuHandler("3", "Payroll", MenuHandler.menuType.MENU)
    };

    
    /**
     * Constructs the Menu and initializes layout and items.
     */
    public Menu() {
        init();
    }
    
    private void init() {
        layout = new MigLayout("wrap 1, fillx, gapy 0, inset 2", "fill", "top");
        setLayout(layout);
        setOpaque(true);

        for (int i = 0; i < menuItems.length; i++) {
            MenuHandler handler = menuItems[i];
            addMenu(handler, i);
        }
    }

    private void addMenu(MenuHandler handler, int index) {
        MenuItem item = new MenuItem(handler.getName(), index);
        item.setIcon(handler.toIcon());  // Uses your existing method!

        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel != null) {
                    mainPanel.removeAll();

                    switch (handler.getName()) {
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
                            mainPanel.add(new PayrollVer2());
                            break;
                    }

                    mainPanel.revalidate();
                    mainPanel.repaint();
                }
                if (selectedItem != null) {
                    selectedItem.setSelected(false);
                }
                item.setSelected(true);
                selectedItem = item;
            }
        });

        add(item);
    }


    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setColor(new Color(0, 66, 102));
        g2.fill(new Rectangle2D.Double(0, 0, getWidth(), getHeight()));
        super.paintComponent(grphcs);
    }
    
    public void selectMenuItemByName(String menuName) {
        for (Component comp : getComponents()) {
            if (comp instanceof MenuItem) {
                MenuItem item = (MenuItem) comp;
                if (item.getText().equals(menuName)) {
                    if (selectedItem != null) {
                        selectedItem.setSelected(false);
                    }
                    item.setSelected(true);
                    selectedItem = item;
                    break;
                }
            }
        }
    }

    
}

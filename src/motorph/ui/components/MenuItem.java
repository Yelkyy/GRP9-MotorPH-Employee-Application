package motorph.ui.components;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * MenuItem represents both main and sub-menu buttons in the dashboard sidebar menu.
 * It supports styling for active submenu items and identifies its position in the menu structure.
 */
public class MenuItem extends JButton {

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the subMenuAble
     */
    public boolean isSubMenuAble() {
        return subMenuAble;
    }

    /**
     * @param subMenuAble the subMenuAble to set
     */
    public void setSubMenuAble(boolean subMenuAble) {
        this.subMenuAble = subMenuAble;
    }

    /**
     * @return the subMenuIndex
     */
    public int getSubMenuIndex() {
        return subMenuIndex;
    }

    /**
     * @param subMenuIndex the subMenuIndex to set
     */
    public void setSubMenuIndex(int subMenuIndex) {
        this.subMenuIndex = subMenuIndex;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }
    private int index;
    private boolean subMenuAble;
    
    private int subMenuIndex;
    private int length;
    //  Submenu
    

    /**
     * Constructs a MenuItem with a name, index, and submenu capability.
     * 
     * @param name         Display name of the menu item
     * @param index        Index of the item in the main menu array
     * @param subMenuAble  True if this item can have submenus
     */
    public MenuItem(String name, int index, boolean subMenuAble) {
        super(name);
        this.index = index;
        this.subMenuAble = subMenuAble;
        
        // Visual styling
        setContentAreaFilled(false);
        setForeground(new Color(230, 230, 230));
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(new EmptyBorder(9, 10, 9, 10));
        setIconTextGap(10);
        setFont(CustomFont.getExtendedRegular(14f));
    }
    
    /**
     * Initializes this button as a submenu item with specific indentation and background color.
     * 
     * @param subMenuIndex Index of this submenu item within its parent
     * @param length       Total number of submenu items
     */
    public void initSubMenu(int subMenuIndex, int length) {
        this.subMenuIndex = subMenuIndex;
        this.length = length;
        setBorder(new EmptyBorder(9, 33, 9, 10));
        setBackground(javax.swing.UIManager.getColor("MenuItem.background"));
        setForeground(javax.swing.UIManager.getColor("MenuItem.foreground"));
        setForeground(Color.WHITE);
        setOpaque(true);
    }
    
}

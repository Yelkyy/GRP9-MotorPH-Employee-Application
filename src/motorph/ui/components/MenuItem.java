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
    
    private int index;
    
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
   

    public MenuItem(String name, int index) {
        super(name);
        this.index = index;
        
        // Visual styling
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        setFocusPainted(false);
        
        setForeground(new Color(230, 230, 230));
        setHorizontalAlignment(SwingConstants.LEFT);
        setBorder(new EmptyBorder(9, 10, 9, 10));
        setIconTextGap(10);
        setFont(CustomFont.getExtendedRegular(14f));
    }
    
    
}

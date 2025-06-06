package motorph.model;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MenuHandler {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public menuType getType() {
        return type;
    }

    public void setType(menuType type) {
        this.type = type;
    }

    public MenuHandler(String icon, String name, menuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public MenuHandler() {
    }

    private String icon;
    private String name;
    private menuType type;

    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/motorph/icons/" + icon + ".png"));
    }

    public static enum menuType {
        TITLE, MENU, EMPTY
    }
}

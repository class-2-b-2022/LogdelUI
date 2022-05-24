package utils;

import java.awt.*;

public class Theme {
    private Color primary = new Color(30,144,255);
    private Color secondary = Color.white;
    private Color subPrimary = new Color(24, 133, 240);
    private Color redForeground = new Color(112,0,0);
    private Color sideBarColor = new Color(31, 31, 115);
    private Color navbarColor = new Color(000033);
    private Color oddRowColor = new Color(
            198, 198, 245
    );

    public Color getPrimary() {
        return primary;
    }

    public void setPrimary(Color primary) {
        this.primary = primary;
    }

    public Color getSecondary() {
        return secondary;
    }

    public void setSecondary(Color secondary) {
        this.secondary = secondary;
    }

    public Color getRedForeground(){
        return redForeground;
    }

    public Color getSubPrimary(){
        return subPrimary;
    }

    public Color getSideBarColor(){
        return sideBarColor;
    }
    public Color getNavbarColor(){
        return navbarColor;
    }

    public Color getOddRowColor() {
        return oddRowColor;
    }
}

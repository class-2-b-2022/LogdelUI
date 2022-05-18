package utils;

import java.awt.*;

public class Theme {
    private Color primary = new Color(30,144,255);
    private Color secondary = Color.white;

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
}

package views.customPalettes;

import java.awt.*;

public enum CustomColor {
    TITLE(Color.decode("#EBBFBF")),
    BROWN(Color.decode("#713C3C")),
    LIGHTBROWN(Color.decode("#9D6969")),
    GREEN(Color.decode("#609B62")),
    ORANGE(Color.decode("#FC9355")),
    GREY(Color.decode("#988686")),
    PINK(Color.decode("#F58998")),
    RED(Color.decode("#E25D5D")),
    LIGHTYELLOW(Color.decode("#F2C18D")),
    YELLOW(Color.decode("#FDCB61"));

    private final Color color;

    CustomColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}


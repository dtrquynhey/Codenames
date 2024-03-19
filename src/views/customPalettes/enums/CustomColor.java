package views.customPalettes.enums;

import java.awt.*;

public enum CustomColor {
    TITLE(Color.decode("#EBBFBF")),
    BROWN(Color.decode("#713C3C")),
    LIGHT_BROWN(Color.decode("#9D6969")),
    CONTAINER_BROWN(Color.decode("#8B5050")),
    GREEN(Color.decode("#609B62")),
    ORANGE(Color.decode("#FC9355")),
    GREY(Color.decode("#988686")),
    PINK(Color.decode("#F58998")),
    RED(Color.decode("#E25D5D")),
    LIGHT_YELLOW(Color.decode("#F2C18D")),
    YELLOW(Color.decode("#FDCB61")),
    RED_COMBOBOX(Color.decode("#B54323")),
    BLUE_COMBOBOX(Color.decode("#79A4D3"));

    private final Color color;

    CustomColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}


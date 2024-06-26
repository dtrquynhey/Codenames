package views.customPalettes.enums;

import java.awt.*;

public enum CustomColor {
    TEXT(Color.decode("#EBBFBF")),
    FRAME(Color.decode("#8B5050")),
    FRAME_RED(Color.decode("#B83636")),
    FRAME_BLUE(Color.decode("#1D4E84")),
    TEXT_BG(Color.decode("#9D6969")),
    CONTAINER_BROWN(Color.decode("#925353")),
    GREEN(Color.decode("#609B62")),
    ORANGE(Color.decode("#FC9355")),
    GREY(Color.decode("#988686")),
    PINK(Color.decode("#F58998")),
    RED(Color.decode("#E25D5D")),
    LIGHT_YELLOW(Color.decode("#F2C18D")),
    YELLOW(Color.decode("#FDCB61")),
    RED_COMBOBOX(Color.decode("#D66868")),
    BLUE_COMBOBOX(Color.decode("#79A4D3")),
    CARD_RED(Color.decode("#D66868")),
    CARD_BLUE(Color.decode("#79A4D3")),
    CARD_NEUTRAL(Color.decode("#B8A37B")),
    CARD_ASSASSIN(Color.decode("#565050"));

    private final Color color;

    CustomColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}


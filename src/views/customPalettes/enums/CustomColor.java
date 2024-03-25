package views.customPalettes.enums;

import java.awt.*;

public enum CustomColor {
    TEXT_WHITE(Color.decode("#FFFFFF")),
    FRAME_GREEN(Color.decode("#547B74")),
    FRAME_RED(Color.decode("#713C3C")),
    FRAME_BLUE(Color.decode("#1D4E84")),
    TEXT_BG_GREEN(Color.decode("#9D6969")),
    CONTAINER_GREEN(Color.decode("#63847D")),
    GREEN(Color.decode("#609B62")),
    ORANGE(Color.decode("#FC9355")),
    GREY(Color.decode("#988686")),
    PINK(Color.decode("#F58998")),
    RED(Color.decode("#E25D5D")),
    LIGHT_YELLOW(Color.decode("#F2C18D")),
    YELLOW(Color.decode("#FDCB61")),
    RED_COMBOBOX(Color.decode("#B54323")),
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


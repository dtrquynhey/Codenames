package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    private static final String FONT_FAMILY = "Bookman Old Style";
    private static final int FONT_STYLE = Font.BOLD;

    public Label(String text, int fontSize, Color foreGroundColor) {
        super(text);
        setFont(new Font(FONT_FAMILY, FONT_STYLE, fontSize));
        setForeground(foreGroundColor);
    }

}

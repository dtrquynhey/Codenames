package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    private static final String FONT_FAMILY = "Bookman Old Style";

    public Label(String text, int fontStyle, int fontSize, Color foreGroundColor) {
        super(text);
        setFont(new Font(FONT_FAMILY, fontStyle, fontSize));
        setForeground(foreGroundColor);
    }

}

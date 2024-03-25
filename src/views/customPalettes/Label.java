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

    @Override
    protected void paintComponent(Graphics g) {
        // Center the text horizontally
        FontMetrics metrics = g.getFontMetrics(getFont());
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(getText(), x, y);
    }
}

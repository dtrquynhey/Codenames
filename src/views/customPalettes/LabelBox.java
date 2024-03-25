package views.customPalettes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class LabelBox extends JLabel {

    private final Color shadowColor = new Color(0, 0, 0, 50); // Semi-transparent black color for shadow
    private final Color bgColor;
    private static final String FONT_FAMILY = "Bookman Old Style";

    public LabelBox(String text, Color bgColor, Color fgColor, Dimension dimension) {
        super(text);
        this.bgColor = bgColor;

        setFont(new Font(FONT_FAMILY, Font.BOLD, 15));
        setPreferredSize(dimension);
        setForeground(fgColor);
        setBackground(bgColor);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow border
        g2d.setColor(shadowColor);
        g2d.fill(new RoundRectangle2D.Float(3, 3, getWidth() - 6, getHeight() - 6, 17, 17));

        // Draw text field background
        g2d.setColor(bgColor);
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 6, getHeight() - 6, 17, 17));

        // Draw text
        FontMetrics metrics = g2d.getFontMetrics(getFont());
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent() - 3; // Adjusted y-coordinate
        g2d.setColor(getForeground());
        g2d.drawString(getText(), x, y);

        g2d.dispose();
    }
}

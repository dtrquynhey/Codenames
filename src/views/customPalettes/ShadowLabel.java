package views.customPalettes;

import javax.swing.*;
import java.awt.*;

// Custom label class with drop shadow effect
public class ShadowLabel extends JLabel {
    private final Color shadowColor = new Color(0, 0, 0, 50);

    public ShadowLabel(String text) {
        super(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(getFont());

        // Get text dimensions
        FontMetrics metrics = g2d.getFontMetrics();
        int textWidth = metrics.stringWidth(getText());
        int textHeight = metrics.getHeight();

        // Calculate shadow position
        int shadowOffsetX = 6; // Adjust the horizontal offset
        int shadowOffsetY = 6; // Adjust the vertical offset
        int x = (getWidth() - textWidth) / 2 + shadowOffsetX; // Move right
        int y = (getHeight() - textHeight) / 2 + metrics.getAscent() + shadowOffsetY; // Move down

        // Draw shadow
        g2d.setColor(shadowColor);
        g2d.drawString(getText(), x, y);

        // Draw text
        g2d.setColor(getForeground());
        g2d.drawString(getText(), (getWidth() - textWidth) / 2, (getHeight() - textHeight) / 2 + metrics.getAscent());

        g2d.dispose();
    }
}

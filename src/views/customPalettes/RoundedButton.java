package views.customPalettes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private final int arcWidth;
    private final int arcHeight;
    private final Color shadowColor;

    public RoundedButton(String text) {
        super(text);
        this.arcWidth = 15;
        this.arcHeight = 15;
        this.shadowColor = new Color(0, 0, 0, 90); // Semi-transparent black color for shadow
        this.setFont(new Font("Cambria", Font.BOLD, 16));
        this.setPreferredSize(new Dimension(150, 40));

        this.setContentAreaFilled(false); // Make the button transparent
        this.setFocusPainted(false); // Remove focus border
        this.setBorderPainted(false);
        this.setEnabled(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow
        g2.setColor(shadowColor);
        g2.fill(new RoundRectangle2D.Float(3, 3, getWidth() - 3, getHeight() - 3, arcWidth, arcHeight));

        // Paint the background with the button's background color
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 3, getHeight() - 3, arcWidth, arcHeight));

        // Paint the text
        super.paintComponent(g2);

        g2.dispose();
    }

}

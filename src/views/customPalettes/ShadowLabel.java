package views.customPalettes;

import javax.swing.*;
import java.awt.*;

// Custom label class with drop shadow effect
public class ShadowLabel extends JLabel {
    private final Color shadowColor = new Color(0, 0, 0, 150);

    public ShadowLabel(String text) {
        super(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(getFont());

        // Draw shadow
        g2.setColor(shadowColor);
        int shadowOffset = -5;
        g2.drawString(getText(), shadowOffset, getHeight() - shadowOffset);

        // Draw text
        g2.setColor(Color.WHITE);


        g2.drawString(getText(), 0, getHeight());

        g2.dispose();
    }
}

package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class ContainerPanel extends JPanel {
    private final Color shadowColor = new Color(0, 0, 0, 50); // Semi-transparent black color for shadow
    private final Color backgroundColor;
    private final Dimension panelDimension;

    public ContainerPanel(Color bgColor, Dimension dimension) {
        backgroundColor = bgColor;
        panelDimension = dimension;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow border
        g2d.setColor(shadowColor);
        g2d.fillRoundRect(3, 3, getWidth() - 3, getHeight() - 3, 17, 17);

        // Draw rounded rectangle background
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, getWidth() - 3, getHeight() - 3, 17, 17);

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return panelDimension; // Set preferred size
    }
}

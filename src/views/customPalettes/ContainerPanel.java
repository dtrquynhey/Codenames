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

        int width = getWidth();
        int height = getHeight();

        // Draw shadow border
        g2d.setColor(shadowColor);
        g2d.fillRoundRect(6, 6, width - 12, height - 12, 25, 25);

        // Draw rounded rectangle background
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, width - 6, height - 6, 25, 25);

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return panelDimension; // Set preferred size
    }
}

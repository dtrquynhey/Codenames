package views.customPalettes;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ComboBox extends JComboBox<String> {
    private final Color shadowColor = new Color(0, 0, 0, 50); // Semi-transparent black color for shadow

    public ComboBox(String[] items, Dimension dimension, Color color) {
        super(items);
        setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        setPreferredSize(dimension);
        setForeground(Color.WHITE);
        setBackground(color);
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20));

        // Remove the default arrow
        setUI(new BasicComboBoxUI() {
            @Override
            protected JButton createArrowButton() {
                return new JButton() {
                    @Override
                    public int getWidth() {
                        return 0;
                    }
                };
            }

            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw shadow border
                g2d.setColor(shadowColor);
                g2d.fill(new RoundRectangle2D.Float(3, 3, c.getWidth() - 3, c.getHeight() - 3, 17, 17));

                // Draw combo box background
                g2d.setColor(color);
                g2d.fill(new RoundRectangle2D.Float(0, 0, c.getWidth() - 3, c.getHeight() - 3, 17, 17));

                // Draw selected item
                super.paint(g2d, c);

                // Draw arrow
                int arrowX = c.getWidth() - 20;
                int arrowY = c.getHeight() / 2 - 2;
                g2d.setColor(Color.WHITE.darker()); // Set the arrow color explicitly to white
                g2d.drawLine(arrowX, arrowY, arrowX + 8, arrowY);
                g2d.drawLine(arrowX, arrowY + 1, arrowX + 8, arrowY + 1);
                g2d.drawLine(arrowX + 1, arrowY + 2, arrowX + 7, arrowY + 2);
                g2d.drawLine(arrowX + 2, arrowY + 3, arrowX + 6, arrowY + 3);
                g2d.drawLine(arrowX + 3, arrowY + 4, arrowX + 5, arrowY + 4);

                g2d.dispose();
            }
        });
    }

    public void setSelectedItem(String item) {
        super.setSelectedItem(item);
    }
}

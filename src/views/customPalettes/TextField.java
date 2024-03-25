package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class TextField extends JTextField {
    private final Color shadowColor = new Color(0, 0, 0, 50); // Semi-transparent black color for shadow
    private String placeholder;

    public TextField(String placeholder, Dimension dimension) {
        super();
        setPlaceholder(placeholder);
        setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        setPreferredSize(dimension);
        setForeground(Color.WHITE);
        setBackground(CustomColor.TEXT_BG.getColor());
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 20, 5, 20)); // Add padding to the text field
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw shadow border
        g2d.setColor(shadowColor);
        g2d.fill(new RoundRectangle2D.Float(3, 3, getWidth() - 3, getHeight() - 3, 17, 17));

        // Draw text field background
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 3, getHeight() - 3, 17, 17));

        // Draw text or placeholder text
        if (!getText().isEmpty() || placeholder == null) {
            super.paintComponent(g2d);
        } else {
            g2d.setColor(Color.WHITE.darker()); // Darken the text color for placeholder
            FontMetrics metrics = getFontMetrics(getFont());
            int x = getInsets().left;
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g2d.drawString(placeholder, x, y);
        }

        // Draw cursor if focused and text is empty
        if (isFocusOwner() && getText().isEmpty()) {
            int caretX = getInsets().left;
            int caretY = getHeight() / 2 - getFontMetrics(getFont()).getHeight() / 2;
            g2d.setColor(getCaretColor());
            g2d.drawLine(caretX, caretY, caretX, caretY + getFontMetrics(getFont()).getHeight());
        }

        g2d.dispose();
    }



    @Override
    public Color getCaretColor() {
        return Color.WHITE;
    }
}

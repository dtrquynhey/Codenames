package views.customPalettes;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class PasswordField extends JPasswordField {

    private final Color shadowColor = new Color(0, 0, 0, 50); // Semi-transparent black color for shadow
    private String placeholder;

    public PasswordField(String placeholder, Dimension dimension) {
        super();
        setPlaceholder(placeholder);
        setFont(new Font("Bookman Old Style", Font.PLAIN, 18));
        setPreferredSize(dimension);
        setForeground(Color.WHITE);
        setBackground(CustomColor.LIGHTBROWN.getColor());
        setOpaque(false); // Make the text field transparent
        setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding to the text field
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
        if (getText().isEmpty() && placeholder != null) {
            g2d.setColor(Color.WHITE.darker()); // Darken the text color for placeholder
            FontMetrics metrics = getFontMetrics(getFont());
            int x = getInsets().left;
            int y = (getHeight() - metrics.getHeight()) / 2 + metrics.getAscent();
            g2d.drawString(placeholder, x, y);
        } else {
            super.paintComponent(g2d);
        }

        // Draw cursor if focused
        if (isFocusOwner() && getText().isEmpty() && placeholder == null) {
            int caretX = getInsets().left + getFontMetrics(getFont()).stringWidth(getText());
            int caretY = getHeight() / 2 - getFontMetrics(getFont()).getHeight() / 2;
            g2d.setColor(getCaretColor());
            g2d.drawLine(caretX, caretY, caretX, caretY + getFontMetrics(getFont()).getHeight());
        }
    }

    @Override
    public Color getCaretColor() {
        return Color.WHITE;
    }

}
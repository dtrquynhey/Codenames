package views.customPalettes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Label extends JLabel {
    private static final String FONT_FAMILY = "Bookman Old Style";
    private boolean clickable = false;
    private ClickListener clickListener;

    public Label(String text, int fontStyle, int fontSize, Color foreGroundColor) {
        super(text);
        setFont(new Font(FONT_FAMILY, fontStyle, fontSize));
        setForeground(foreGroundColor);


        // Method to enable or disable click functionality

    }

    public void setClickable(boolean clickable) {
        this.clickable = clickable;
        if (clickable) {
            // Add mouse listener to handle click events
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (clickListener != null) {
                        clickListener.onClick(Label.this);
                    }
                }
            });
        } else {
            // Remove mouse listener if not clickable
            removeMouseListener(getMouseListeners()[0]);
        }
    }

    // Method to set the click listener
    public void addActionListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Center the text horizontally
        FontMetrics metrics = g.getFontMetrics(getFont());
        int x = (getWidth() - metrics.stringWidth(getText())) / 2;
        int y = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
        g.drawString(getText(), x, y);
    }


    // Interface for click listener
    public interface ClickListener {
        void onClick(Label label);
    }
}

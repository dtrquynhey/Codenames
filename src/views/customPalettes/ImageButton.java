package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class ImageButton extends JButton {
    private Image image;

    public ImageButton(String imagePath, int width, int height) {
        ImageIcon icon = new ImageIcon(imagePath);
        image = icon.getImage();
        setPreferredSize(new Dimension(width, height));
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setEnabled(true);
    }

    public void setImage(String imagePath) {
        // Load the new image from the specified path
        ImageIcon icon = new ImageIcon(imagePath);
        image = icon.getImage();
        repaint(); // Repaint the button to update its appearance
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the image centered within the button bounds
        int x = (getWidth() - image.getWidth(null)) / 2;
        int y = (getHeight() - image.getHeight(null)) / 2;
        g.drawImage(image, x, y, this);
    }

}

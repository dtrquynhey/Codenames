package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageContainer extends JPanel {
    private BufferedImage backgroundImage;

    public ImageContainer(String imagePath) {
        // Set a default size
        setPreferredSize(new Dimension(300, 200));
        setBackground(CustomColor.CONTAINER_BROWN.getColor());
        try {
            // Load the background image
            backgroundImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Create a Graphics2D object
        Graphics2D g2d = (Graphics2D) g.create();

        if (backgroundImage != null) {
            // Draw the rounded rectangle with drop shadow
            int shadowGap = 5;
            int cornerRadius = 15;
            int width = getWidth() - shadowGap;
            int height = getHeight() - shadowGap;

            // Set shadow properties
            Color shadowColor = new Color(0, 0, 0, 100);
            int shadowOffsetX = 4;
            int shadowOffsetY = 4;

            // Draw shadow
            g2d.setColor(shadowColor);
            g2d.fillRoundRect(shadowOffsetX, shadowOffsetY, width, height, cornerRadius, cornerRadius);

            // Draw the background image inside the rounded rectangle
            g2d.clip(new RoundRectangle2D.Double(0, 0, width, height, cornerRadius, cornerRadius));
            g2d.drawImage(backgroundImage, 0, 0, width, height, this);

            g2d.dispose();
        }
    }
}

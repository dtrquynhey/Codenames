package views.customPalettes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Frame extends JFrame {

    protected JPanel panel;

    public Frame(LayoutManager layoutManager) {
        setTitle("Codenames Desktop Game");
        setIconImage(new ImageIcon("src/assets/icon.jpeg").getImage());
        setSize(1280, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

//        try {
//            final Image backgroundImage = ImageIO.read(new File("src/assets/background.png"));
//            panel = new JPanel(layoutManager) {
//                @Override
//                public void paintComponent(Graphics g) {
//                    g.drawImage(backgroundImage, 0, 0, null);
//                }
//            };
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        panel = new JPanel(layoutManager);
        panel.setBackground(Color.decode("#713C3C"));
        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Frame(new GridLayout());
    }
}

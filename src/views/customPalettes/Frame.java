package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame() {
        setTitle("Codenames Desktop Game");
        setIconImage(new ImageIcon("assets/icon.jpeg").getImage());
        setSize(1080, 810);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        GridBagLayout gridBagLayout = new GridBagLayout();
        JPanel panel = new JPanel(gridBagLayout);
        panel.setBackground(Color.decode("#713C3C"));
        setContentPane(panel);
        setVisible(true);

    }

}

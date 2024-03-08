package views.GUI;

import javax.swing.*;
import java.awt.*;

public class RulesUI extends JFrame {

    public RulesUI() {

        setTitle("Codenames Desktop Game");
        setIconImage(new ImageIcon("assets/icon.jpg").getImage());
        setSize(1080, 810);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GridBagLayout gridBagLayout = new GridBagLayout();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JPanel panel = new JPanel(gridBagLayout);
        panel.setBackground(Color.decode("#713C3C"));
        setContentPane(panel);

        JLabel lblComingSoon = new JLabel("This feature is coming soon...");
        lblComingSoon.setForeground(Color.WHITE);
        lblComingSoon.setFont(new Font("Cambria", Font.PLAIN, 20));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 20, 0);
        panel.add(lblComingSoon, gridBagConstraints);

        setVisible(true);

    }

    public static void main(String[] args) {
        new RulesUI();
    }
}

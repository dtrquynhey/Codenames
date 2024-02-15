package views;

import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends JFrame{

    public WelcomeUI() {

        this.setTitle("Codenames Desktop Game");
        this.setIconImage(new ImageIcon("assets/icon.jpg").getImage());
        this.setSize(1080, 810);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        GridBagLayout gridBagLayout = new GridBagLayout();
        JPanel panel = new JPanel(gridBagLayout);
        panel.setBackground(Color.decode("#713C3C"));
        this.setContentPane(panel);

        JLabel lblTitle = new ShadowLabel("CODENAMES");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Cambria", Font.PLAIN, 100));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 20, 0);
        panel.add(lblTitle, gridBagConstraints);

        RoundedButton btnNewGame = new RoundedButton("New Game");
        btnNewGame.setBackground(Color.decode("#52D547"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 4, 0);
        panel.add(btnNewGame, gridBagConstraints);

        RoundedButton btnReadRules = new RoundedButton("Read Rules");
        btnReadRules.setBackground(Color.decode("#E4F241"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);

        panel.add(btnReadRules, gridBagConstraints);

        this.setVisible(true);

    }

    public static void main(String[] args) {
        new WelcomeUI();
    }

}

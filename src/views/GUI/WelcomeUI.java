package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends Frame {

    public WelcomeUI() {
        super(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblTitle = new ShadowLabel("CODENAMES");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Bookman Old Style", Font.PLAIN, 80));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 25, 0);
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

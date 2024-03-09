package views.gui;

import views.customPalettes.Frame;
import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;
import views.uihelpers.UIManager;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends Frame {

    public WelcomeUI() {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, Color.decode("#84BDBF"));
        topFlowPanel.add(buttonReadRules);

        RoundedButton buttonLogOut = new RoundedButton("Log Out", 130, 42, Color.decode("#ACA7A7"));
        topFlowPanel.add(buttonLogOut);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblTitle = new ShadowLabel("CODENAMES", 100, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(lblTitle,gridBagConstraints);

        RoundedButton btnNewGame = new RoundedButton("New Game", 140, 42, Color.decode("#F1B8C0"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(btnNewGame, gridBagConstraints);

        buttonReadRules.addActionListener(e -> UIManager.openRulesUI());

        this.setVisible(true);

    }

    public static void main(String[] args) {

        new WelcomeUI();
    }

}

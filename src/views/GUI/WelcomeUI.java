package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends Frame {

    public WelcomeUI() {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, Color.decode("#84BDBF"));
        RoundedButton buttonLogOut = new RoundedButton("Log Out", 130, 42, Color.decode("#ACA7A7"));
        topFlowPanel.add(buttonReadRules);
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

        buttonReadRules.addActionListener(e -> {
            openRulesUI();
        });

        this.setVisible(true);

    }

    private void openRulesUI() {

        RulesUI ruleUI = new RulesUI();
        ruleUI.setVisible(true);
    }

    public static void main(String[] args) {

        new WelcomeUI();
    }

}

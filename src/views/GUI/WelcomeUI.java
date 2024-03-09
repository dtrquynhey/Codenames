package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;
import views.customPalettes.TopFlowPanel;

import javax.swing.*;
import java.awt.*;

public class WelcomeUI extends Frame {

    public WelcomeUI() {
        super();

        topFlowPanel.addButton(new RoundedButton("Read Rules", 110, 42, Color.decode("#84BDBF")));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblTitle = new ShadowLabel("CODENAMES", 96, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        panel.add(lblTitle, gridBagConstraints);

        RoundedButton btnNewGame = new RoundedButton("New Game", 140, 42, Color.decode("#E5D1D2"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        panel.add(btnNewGame, gridBagConstraints);

        RoundedButton btnReadRules = new RoundedButton("Read Rules", 140, 42, Color.decode("#E4C988"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        panel.add(btnReadRules, gridBagConstraints);

        RoundedButton btnLogOut = new RoundedButton("Log Out", 140, 42, Color.decode("#FC9355"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        panel.add(btnLogOut, gridBagConstraints);

        btnReadRules.addActionListener(e -> {
            // Open RuleUI when the button is clicked
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

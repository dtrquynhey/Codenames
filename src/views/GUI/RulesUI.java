package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.Label;
import views.customPalettes.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class RulesUI extends Frame {

    public RulesUI() {
        super();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblComingSoon = new Label("This feature is coming soon!", Font.PLAIN, 16 , Color.WHITE );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(lblComingSoon, gridBagConstraints);

        RoundedButton btnGoBack = new RoundedButton("Go Back", 120, 42, Color.decode("#ACA7A7"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 4, 0);
        centerGridBagPanel.add(btnGoBack, gridBagConstraints);

        btnGoBack.addActionListener(e -> {
            backToWelcomeUI();
        });

        this.setVisible(true);

    }

    private void backToWelcomeUI() {
        dispose();
    }

    public static void main(String[] args) {
        new RulesUI();
    }
}

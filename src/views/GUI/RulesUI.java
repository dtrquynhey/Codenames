package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.Label;
import views.customPalettes.RoundedButton;

import javax.swing.*;
import java.awt.*;

public class RulesUI extends Frame {

    public RulesUI() {
        super(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblComingSoon = new Label("This feature is coming soon ^_^ ", 20, Color.WHITE );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        panel.add(lblComingSoon, gridBagConstraints);

        RoundedButton btnGoBack = new RoundedButton("Go Back", 120, 42, Color.decode("#FC9355"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 4, 0);
        panel.add(btnGoBack, gridBagConstraints);

        btnGoBack.addActionListener(e -> {
            // Go back to WelcomeUI when the button is clicked
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

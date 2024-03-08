package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;

import javax.swing.*;
import java.awt.*;

public class RulesUI extends Frame {

    public RulesUI() {
        super(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblComingSoon = new ShadowLabel("This feature is coming soon...!");
        lblComingSoon.setForeground(Color.WHITE);
        lblComingSoon.setFont(new Font("Cambria", Font.PLAIN, 22));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        panel.add(lblComingSoon, gridBagConstraints);

        RoundedButton btnGoBack = new RoundedButton("Go Back");
        btnGoBack.setBackground(Color.decode("#E4F241"));
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

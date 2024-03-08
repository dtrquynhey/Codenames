package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.RoundedButton;
import views.customPalettes.ShadowLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeUI extends Frame {

    private JButton button1;

    public WelcomeUI() {
        super(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblTitle = new ShadowLabel("CODENAMES");
        lblTitle.setForeground(Color.WHITE);
        lblTitle.setFont(new Font("Cambria", Font.PLAIN, 80));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
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
        gridBagConstraints.insets = new Insets(4, 0, 0, 0);

        panel.add(btnReadRules, gridBagConstraints);

        // Add ActionListener to the "Read Rules" button
        btnReadRules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open RuleUI when the button is clicked
                openRulesUI();
            }
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

package views.gui;

import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.TextField;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends MainPanel {

    public LoginPanel() {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, Color.decode("#84BDBF"));
        topFlowPanel.add(buttonReadRules);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel labelTitle = new ShadowLabel("CODENAMES", 100, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle,gridBagConstraints);

        JTextField textFieldUsername = new TextField("Username", new Dimension(275, 42));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(textFieldUsername, gridBagConstraints);

        JPasswordField passwordField = new PasswordField("Password", new Dimension(275, 42));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(passwordField, gridBagConstraints);

        JButton buttonLogIn = new RoundedButton("Log In", 110, 42, Color.decode("#FC9355"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonLogIn, gridBagConstraints);

        CenterGridBagPanel signUpPanel = new CenterGridBagPanel();

        JLabel labelSignUp = new Label("Don't have an account yet?", Font.PLAIN, 16, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        signUpPanel.add(labelSignUp, gridBagConstraints);

        RoundedButton buttonSignUp = new RoundedButton("Sign Up", 110, 42, Color.decode("#E4C988"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        signUpPanel.add(buttonSignUp, gridBagConstraints);

        bottomFlowPanel.add(signUpPanel);

        setVisible(true);
    }

    public static void main(String[] args) {

        new LoginPanel();
    }
}

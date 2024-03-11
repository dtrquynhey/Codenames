package views.gui;

import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.TextField;

import java.awt.*;

public class SignupPanel extends MainPanel {

    public SignupPanel() {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, Color.decode("#84BDBF"));
        topFlowPanel.add(buttonReadRules);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel lblTitle = new ShadowLabel("CODENAMES", 100, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(lblTitle, gridBagConstraints);

        TextField textFieldUsername = new TextField("Username", new Dimension(275, 42));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(textFieldUsername, gridBagConstraints);

        PasswordField passwordField = new PasswordField("Password", new Dimension(275, 42));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(passwordField, gridBagConstraints);

        PasswordField confirmPasswordField = new PasswordField("Confirm Password", new Dimension(275, 42));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(confirmPasswordField, gridBagConstraints);

        RoundedButton buttonSignUp = new RoundedButton("Sign Up", 110, 42, Color.decode("#FC9355"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonSignUp, gridBagConstraints);

        CenterGridBagPanel logInPanel = new CenterGridBagPanel();

        Label labelSignUp = new Label("Already have an account?", Font.PLAIN, 16, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        logInPanel.add(labelSignUp, gridBagConstraints);

        RoundedButton buttonLogIn = new RoundedButton("Log In", 110, 42, Color.decode("#E4C988"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        logInPanel.add(buttonLogIn, gridBagConstraints);

        bottomFlowPanel.add(logInPanel);

        setVisible(true);
    }
}

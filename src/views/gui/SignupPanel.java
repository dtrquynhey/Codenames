package views.gui;

import controllers.AccountController;
import models.Account;
import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class SignupPanel extends MainPanel {

    public SignupPanel(AccountController accountController) {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelTitle = new ShadowLabel("CODENAMES", 100, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle, gridBagConstraints);

        SignupInfoPanel signupInfoPanel = new SignupInfoPanel();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(signupInfoPanel, gridBagConstraints);

        RoundedButton buttonSignUp = new RoundedButton("Sign Up", 110, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonSignUp, gridBagConstraints);

        CenterGridBagPanel logInPanel = new CenterGridBagPanel();

        Label labelSignUp = new Label("Already have an account?", Font.PLAIN, 16, Color.WHITE.darker());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        logInPanel.add(labelSignUp, gridBagConstraints);

        RoundedButton buttonLogIn = new RoundedButton("Log In", 110, 42, CustomColor.ORANGE.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        logInPanel.add(buttonLogIn, gridBagConstraints);

        bottomFlowPanel.add(logInPanel);



        buttonSignUp.addActionListener(e -> {
            String username = signupInfoPanel.getUsername();
            String password = signupInfoPanel.getPassword();
            String confirmPassword = signupInfoPanel.getConfirmPassword();

            switch (accountController.isValidSignupCredentials(username, password, confirmPassword)) {
                case EMPTY_FIELDS -> signupInfoPanel.showError("All the fields are required.");
                case PASSWORD_MISMATCH -> signupInfoPanel.showError("Passwords do not match.");
                case EXISTING_USER -> signupInfoPanel.showError("This username is already in use.");
                case SUCCESS -> {
                    accountController.signPlayerUp(username, password);
                    signupInfoPanel.resetPanel();
                    new MessageDialog(this, "Account has been successfully created! Please log in to start playing.", "Sign Up Success");
                }
            }
        });

        buttonLogIn.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(SignupPanel.this);
            mainFrame.showLoginPanel();
        });

        buttonReadRules.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(SignupPanel.this);
            mainFrame.showRulesPanel();
        });

        setVisible(true);
    }
}

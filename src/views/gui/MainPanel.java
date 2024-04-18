package views.gui;

import controllers.AccountController;
import controllers.PlayerController;
import views.customPalettes.*;
import views.customPalettes.Panel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends Panel {

    public MainPanel(AccountController accountController, PlayerController playerController) {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel labelTitle = new ShadowLabel("CODENAMES", 100, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        centerGridBagPanel.add(labelTitle, gridBagConstraints);

        gridBagConstraints.gridwidth = 1;

        LoginInfoPanel loginInfoPanel = new LoginInfoPanel();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 90);
        centerGridBagPanel.add(loginInfoPanel, gridBagConstraints);

        JButton buttonLogIn = new RoundedButton("Log In", 110, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 0, 0, 90);
        centerGridBagPanel.add(buttonLogIn, gridBagConstraints);

        SignupInfoPanel signupInfoPanel = new SignupInfoPanel();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 90, 0, 0);
        centerGridBagPanel.add(signupInfoPanel, gridBagConstraints);

        RoundedButton buttonSignUp = new RoundedButton("Sign Up", 110, 42, CustomColor.ORANGE.getColor());
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 90, 0, 0);
        centerGridBagPanel.add(buttonSignUp, gridBagConstraints);


        buttonLogIn.addActionListener(e -> {
            String username = loginInfoPanel.getUsername();
            String password = String.valueOf(loginInfoPanel.getPassword());

            switch (accountController.isValidLoginCredentials(username, password)) {
                case EMPTY_FIELDS -> loginInfoPanel.showError("All the fields are required.");
                case INVALID_CREDENTIALS -> loginInfoPanel.showError("The credentials is invalid.");
                case SUCCESS -> {
                    accountController.logIn(username);
                    loginInfoPanel.resetPanel();
                    accountController.setFirstAccount(username);

                    HomePanel homePanel = new HomePanel(accountController, playerController);
                    MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(MainPanel.this);
                    mainFrame.showPanel(homePanel);

                }
            }
        });

        buttonSignUp.addActionListener(e -> {
            String username = signupInfoPanel.getUsername();
            String password = signupInfoPanel.getPassword();
            String confirmPassword = signupInfoPanel.getConfirmPassword();

            switch (accountController.isValidSignUpCredentials(username, password, confirmPassword)) {
                case EMPTY_FIELDS -> signupInfoPanel.showError("All the fields are required.");
                case PASSWORD_MISMATCH -> signupInfoPanel.showError("Passwords do not match.");
                case EXISTING_USER -> signupInfoPanel.showError("This username is already in use.");
                case SUCCESS -> {
                    accountController.signUp(username, password);
                    signupInfoPanel.resetPanel();
                    new MessageDialog(this, "Account has been successfully created! Please log in to start playing.", "Sign Up Success", "OK");
                }
            }
        });

        buttonReadRules.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(MainPanel.this);
            mainFrame.showRulesPanel();
        });


        setVisible(true);
    }
}

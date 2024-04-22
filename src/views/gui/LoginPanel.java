package views.gui;


import controllers.AccountController;
import controllers.enums.AuthenticationResult;
import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.Panel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends Panel {
    private Runnable onLoginSuccess;

    public LoginPanel(AccountController accountController) {

        super();

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelLogin = new ShadowLabel("LOG IN", 35, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(15, 0, 15, 0);
        centerGridBagPanel.add(labelLogin,gridBagConstraints);

        LoginInfoPanel loginInfoPanel = new LoginInfoPanel();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(loginInfoPanel, gridBagConstraints);

        JButton buttonLogIn = new RoundedButton("Log In", 110, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonLogIn, gridBagConstraints);


        CenterGridBagPanel signUpPanel = new CenterGridBagPanel();

        JLabel labelSignUp = new Label("Don't have an account yet?", Font.PLAIN, 16, Color.WHITE.darker());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        signUpPanel.add(labelSignUp, gridBagConstraints);

        Label buttonSignUp = new Label("Sign Up", Font.HANGING_BASELINE, 16, Color.WHITE);
        buttonSignUp.setClickable(true);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 10, 0, 0);
        signUpPanel.add(buttonSignUp, gridBagConstraints);


        bottomFlowPanel.add(signUpPanel);


        buttonLogIn.addActionListener(e -> {
            String username = loginInfoPanel.getUsername();
            String password = String.valueOf(loginInfoPanel.getPassword());

            switch (accountController.isValidLoginCredentials(username, password)) {
                case EMPTY_FIELDS -> loginInfoPanel.showError("All the fields are required.");
                case INVALID_CREDENTIALS -> loginInfoPanel.showError("The credentials is invalid.");
                case SUCCESS -> {
                    loginInfoPanel.resetPanel();
                    switch (accountController.addAccount(username)) {
                        case DUPLICATE_NAMES -> new MessageDialog(this, "This account already logged in.", "Log In Failure", "Try Again");
                        case SUCCESS -> {
                            if (onLoginSuccess != null) {
                                onLoginSuccess.run();
                            }
                        }
                    }
                }
            }
        });

        buttonSignUp.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(LoginPanel.this);
            mainFrame.showSignupPanel();
        });

        setVisible(true);
    }

    private AuthenticationResult isValidLoginCredentials(String username, String password) {
        if (username.isEmpty() || password.isEmpty()){
            return AuthenticationResult.EMPTY_FIELDS;
        }
        else return AuthenticationResult.SUCCESS;
    }
    // Setter for the login success listener
    public void onLoginSuccess(Runnable onLoginSuccess) {
        this.onLoginSuccess = onLoginSuccess;
    }
}

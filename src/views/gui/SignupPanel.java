package views.gui;

import controllers.AccountController;
import views.customPalettes.*;
import views.customPalettes.Panel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class SignupPanel extends Panel {

    private final AccountController accountController;

    private final SignupInfoPanel signupInfoPanel;

    public SignupPanel(AccountController accountController) {
        super();
        this.accountController = accountController;

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelSignUp = new ShadowLabel("SIGN UP", 35, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(15, 0, 15, 0);
        centerGridBagPanel.add(labelSignUp,gridBagConstraints);

        signupInfoPanel = new SignupInfoPanel();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(signupInfoPanel, gridBagConstraints);

        RoundedButton buttonSignUp = new RoundedButton("Sign Up", 110, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonSignUp, gridBagConstraints);


        buttonSignUp.addActionListener(e -> {
            buttonSignUpClicked();
        });

        setVisible(true);
    }

    private void buttonSignUpClicked() {
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
                new MessageDialog(this, "Account has been successfully created! Please log in to start playing.", "Sign Up Success");
                PopupFrame mainFrame = (PopupFrame) SwingUtilities.getWindowAncestor(SignupPanel.this);
                mainFrame.dispose();
            }
        }
    }
}

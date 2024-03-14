package views.gui;

import controllers.UserController;
import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class SignupPanel extends MainPanel {

    private final UsernamePanel usernamePanel;
    private final PasswordPanel passwordPanel;
    private final PasswordPanel confirmPasswordPanel;

    public SignupPanel(UserController userController) {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelTitle = new ShadowLabel("CODENAMES", 100, CustomColor.TITLE.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle, gridBagConstraints);

        JPanel signupFieldPanel = new JPanel(new GridBagLayout());
        signupFieldPanel.setBackground(CustomColor.BROWN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(signupFieldPanel, gridBagConstraints);

        GridBagConstraints signupFieldGridBagConstraints = new GridBagConstraints();

        usernamePanel = new UsernamePanel("Username");
        signupFieldGridBagConstraints.gridx = 0;
        signupFieldGridBagConstraints.gridy = 0;
        signupFieldGridBagConstraints.anchor = GridBagConstraints.WEST;
        signupFieldPanel.add(usernamePanel, signupFieldGridBagConstraints);

        passwordPanel = new PasswordPanel("Password");
        signupFieldGridBagConstraints.gridx = 0;
        signupFieldGridBagConstraints.gridy = 1;
        signupFieldGridBagConstraints.insets = new Insets(5, 0, 0, 0);
        signupFieldPanel.add(passwordPanel, signupFieldGridBagConstraints);

        confirmPasswordPanel = new PasswordPanel("Confirm Password");
        signupFieldGridBagConstraints.gridx = 0;
        signupFieldGridBagConstraints.gridy = 2;
        signupFieldGridBagConstraints.insets = new Insets(5, 0, 0, 0);
        signupFieldPanel.add(confirmPasswordPanel, signupFieldGridBagConstraints);

        RoundedButton buttonSignUp = new RoundedButton("Sign Up", 110, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonSignUp, gridBagConstraints);

        IconLabelPanel labelError = new IconLabelPanel("");
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        labelError.setVisible(false);
        centerGridBagPanel.add(labelError, gridBagConstraints);

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
            String username = usernamePanel.getTextFieldUsername();
            String password = String.valueOf(passwordPanel.getPassword());
            String confirmPassword = String.valueOf(confirmPasswordPanel.getPassword());

            switch (userController.registerUser(username, password, confirmPassword)) {
                case EMPTY_FIELDS -> showError(labelError, "All the fields are required.");
                case PASSWORD_MISMATCH -> showError(labelError, "Passwords do not match.");
                case EXISTING_USER -> showError(labelError, "This username is already in use.");
                case SUCCESS -> {
                    labelError.setVisible(false);
                    clearFields();
                    new MessageDialog(this, "Account has been successfully created! Please log in to start playing.", "Success");
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
    private void showError(IconLabelPanel labelError, String errorMessage) {
        labelError.setVisible(true);
        labelError.setText(errorMessage);
    }

    private void clearFields() {
        usernamePanel.setTextFieldUsername("");
        passwordPanel.setPassword("");
        confirmPasswordPanel.setPassword("");
    }
}

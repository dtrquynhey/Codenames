package views.gui;

import controllers.UserController;
import views.customPalettes.*;
import views.customPalettes.Label;

import javax.swing.*;
import java.awt.*;

public class SignupPanel extends MainPanel {

    public SignupPanel() {
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
        GridBagConstraints signupFieldGridBagConstraints = new GridBagConstraints();

        UsernamePanel usernamePanel = new UsernamePanel("Username");
        signupFieldGridBagConstraints.gridx = 0;
        signupFieldGridBagConstraints.gridy = 0;
        signupFieldGridBagConstraints.anchor = GridBagConstraints.WEST;
        signupFieldPanel.add(usernamePanel, signupFieldGridBagConstraints);

        PasswordPanel passwordPanel = new PasswordPanel("Password");
        signupFieldGridBagConstraints.gridx = 0;
        signupFieldGridBagConstraints.gridy = 1;
        signupFieldGridBagConstraints.insets = new Insets(5, 0, 0, 0);
        signupFieldPanel.add(passwordPanel, signupFieldGridBagConstraints);

        PasswordPanel confirmPasswordPanel = new PasswordPanel("Confirm Password");
        signupFieldGridBagConstraints.gridx = 0;
        signupFieldGridBagConstraints.gridy = 2;
        signupFieldGridBagConstraints.insets = new Insets(5, 0, 0, 0);
        signupFieldPanel.add(confirmPasswordPanel, signupFieldGridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(signupFieldPanel, gridBagConstraints);

        RoundedButton buttonSignUp = new RoundedButton("Sign Up", 110, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
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
            UserController.getInstance().signUpButtonClicked(usernamePanel.getTextFieldUsername(), passwordPanel.getPasswordField(), confirmPasswordPanel.getPasswordField());
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

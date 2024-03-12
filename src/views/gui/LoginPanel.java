package views.gui;

import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.TextField;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends MainPanel {


    public LoginPanel() {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel labelTitle = new ShadowLabel("CODENAMES", 100, CustomColor.TITLE.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle,gridBagConstraints);


        JPanel loginFieldPanel = new JPanel(new GridBagLayout());
        loginFieldPanel.setBackground(CustomColor.BROWN.getColor());
        GridBagConstraints loginFieldGridBagConstraints = new GridBagConstraints();

        UsernamePanel usernamePanel = new UsernamePanel("Username");
        loginFieldGridBagConstraints.gridx = 0;
        loginFieldGridBagConstraints.gridy = 0;
        loginFieldGridBagConstraints.anchor = GridBagConstraints.WEST;
        loginFieldPanel.add(usernamePanel, loginFieldGridBagConstraints);

        PasswordPanel passwordPanel = new PasswordPanel("Password");
        loginFieldGridBagConstraints.gridx = 0;
        loginFieldGridBagConstraints.gridy = 1;
        loginFieldGridBagConstraints.insets = new Insets(5, 0, 0, 0);
        loginFieldPanel.add(passwordPanel, loginFieldGridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        centerGridBagPanel.add(loginFieldPanel, gridBagConstraints);


        JButton buttonLogIn = new RoundedButton("Log In", 110, 42, CustomColor.GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonLogIn, gridBagConstraints);


        CenterGridBagPanel signUpPanel = new CenterGridBagPanel();

        JLabel labelSignUp = new Label("Don't have an account yet?", Font.PLAIN, 16, Color.WHITE.darker());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        signUpPanel.add(labelSignUp, gridBagConstraints);

        RoundedButton buttonSignUp = new RoundedButton("Sign Up", 110, 42, CustomColor.ORANGE.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(10, 0, 0, 0);
        signUpPanel.add(buttonSignUp, gridBagConstraints);


        bottomFlowPanel.add(signUpPanel);


        buttonLogIn.addActionListener(e -> {

            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(LoginPanel.this);
            mainFrame.showWelcomePanel();
        });

        buttonSignUp.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(LoginPanel.this);
            mainFrame.showSignupPanel();
        });

        buttonReadRules.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(LoginPanel.this);
            mainFrame.showRulesPanel();
        });


        setVisible(true);
    }
}

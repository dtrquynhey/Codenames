package views.GUI;

import views.customPalettes.*;
import views.customPalettes.Frame;
import views.customPalettes.Label;
import views.customPalettes.TextField;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends Frame {

    public LoginUI() {
        super(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel lblTitle = new ShadowLabel("CODENAMES", 96, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        panel.add(lblTitle, gridBagConstraints);

        JTextField textFieldUsername = new TextField("Username", new Dimension(225, 42));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        panel.add(textFieldUsername, gridBagConstraints);

        JPasswordField passwordField = new PasswordField("Password", new Dimension(225, 42));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        panel.add(passwordField, gridBagConstraints);

        JButton buttonLogIn = new RoundedButton("Log In", 110, 42, Color.decode("#FC9355"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        panel.add(buttonLogIn, gridBagConstraints);

        JLabel labelSignUp = new Label("Don't have an account yet?", Font.PLAIN, 20, Color.WHITE);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        panel.add(labelSignUp, gridBagConstraints);

        setVisible(true);


    }

    public static void main(String[] args) {

        new LoginUI();
    }
}

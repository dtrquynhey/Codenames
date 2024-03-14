package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class PasswordPanel extends JPanel {


    private final PasswordField passwordField;
    private final ImageButton buttonShowPassword;

    public PasswordPanel(String placeholder) {
        setLayout(new GridBagLayout());
        setBackground(CustomColor.BROWN.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel imageLabel = new JLabel(new ImageIcon("src/assets/icon-password.png"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 10);
        add(imageLabel, gridBagConstraints);


        passwordField = new PasswordField(placeholder, new Dimension(275, 42));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 5);
        add(passwordField, gridBagConstraints);

        buttonShowPassword = new ImageButton("src/assets/icon-hide.png", 30, 42);
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(buttonShowPassword, gridBagConstraints);

        buttonShowPassword.addActionListener(e -> togglePasswordFieldVisibility());
    }


    public String getPassword() {
        return passwordField.getText();
    }

    public void setPassword(String password) {
        passwordField.setText(password);
    }

    private void togglePasswordFieldVisibility() {
        if (passwordField.getEchoChar() != '\0') {
            passwordField.setEchoChar('\0');
            buttonShowPassword.setImage("src/assets/icon-eye.png");
        } else {
            passwordField.setEchoChar('*');
            buttonShowPassword.setImage("src/assets/icon-hide.png");
        }
    }
}

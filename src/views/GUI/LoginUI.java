package views.GUI;

import views.customPalettes.Frame;
import views.customPalettes.ShadowLabel;
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

        JTextField textFieldUsername = new TextField("Username", new Dimension(200, 42));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        panel.add(textFieldUsername, gridBagConstraints);

        setVisible(true);

    }

    public static void main(String[] args) {

        new LoginUI();
    }
}

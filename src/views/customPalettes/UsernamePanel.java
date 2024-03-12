package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class UsernamePanel extends JPanel {


    private final TextField textFieldUsername;

    public UsernamePanel(String placeholder) {
        setLayout(new GridBagLayout());
        setBackground(CustomColor.BROWN.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel imageLabel = new JLabel(new ImageIcon("src/assets/icon-username.png"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 10);
        add(imageLabel, gridBagConstraints);


        textFieldUsername = new TextField(placeholder, new Dimension(275, 42));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(textFieldUsername, gridBagConstraints);
    }


    public String getTextFieldUsername() {
        return textFieldUsername.getText();
    }

    public void setTextFieldUsername(String username) {
        this.textFieldUsername.setText(username);
    }
}

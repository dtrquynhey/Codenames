package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class UsernamePanel extends JPanel {

    public UsernamePanel(String placeholder) {
        setLayout(new GridBagLayout());
        setBackground(CustomColor.BROWN.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        JLabel imageLabel = new JLabel(new ImageIcon("src/assets/icon-username.png"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 10);
        add(imageLabel, gridBagConstraints);


        TextField textField = new TextField(placeholder, new Dimension(275, 42));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(textField, gridBagConstraints);
    }

}

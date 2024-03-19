package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class IconTextFieldPanel extends JPanel {

    private final TextField textField;
    private final JLabel iconLabel;

    public IconTextFieldPanel(String placeholder, String fileName) {
        setLayout(new GridBagLayout());
        setBackground(CustomColor.CONTAINER_BROWN.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        iconLabel = new JLabel(new ImageIcon(fileName));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 10);
        add(iconLabel, gridBagConstraints);

        textField = new TextField(placeholder, new Dimension(275, 42));
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(textField, gridBagConstraints);
    }


    public String getTextFieldUsername() {
        return textField.getText();
    }

    public void setTextFieldUsername(String username) {
        this.textField.setText(username);
    }
}

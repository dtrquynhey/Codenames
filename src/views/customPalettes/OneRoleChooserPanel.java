package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class OneRoleChooserPanel extends JPanel {

    private final ComboBox comboBox;

    public OneRoleChooserPanel(String[] playerNicknames, String defaultPlayerNickname, String imagePath, Color comboBoxColor) {
        setLayout(new GridBagLayout());
        setBackground(CustomColor.CONTAINER_GREEN.getColor());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        comboBox = new ComboBox(playerNicknames, new Dimension(205, 42), comboBoxColor);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(-25, 0, 0, 0);
        comboBox.setSelectedItem(defaultPlayerNickname);
        add(comboBox, gridBagConstraints);

        ImageContainer imageContainer = new ImageContainer(imagePath, new Dimension(300, 200), CustomColor.CONTAINER_GREEN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(imageContainer, gridBagConstraints);
    }


    public String getSelectedPlayer() {
        return Objects.requireNonNull(comboBox.getSelectedItem()).toString();
    }
}

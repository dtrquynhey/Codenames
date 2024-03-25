package views.customPalettes;

import models.Player;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

public class OneRoleChooserPanel extends JPanel {

    private final ComboBox comboBox;

    public OneRoleChooserPanel(List<Player> playerList, String defaultPlayerNickname, String imagePath, Color comboBoxColor) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        comboBox = new ComboBox(playerList, new Dimension(205, 42), comboBoxColor);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(-25, 0, 0, 0);
        comboBox.setSelectedItem(defaultPlayerNickname);
        add(comboBox, gridBagConstraints);

        ImageContainer imageContainer = new ImageContainer(imagePath, new Dimension(300, 200), CustomColor.CONTAINER_BROWN.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(imageContainer, gridBagConstraints);
    }


    public Player getSelectedPlayer() {
        return new Player(Objects.requireNonNull(comboBox.getSelectedItem()).toString());
    }
}

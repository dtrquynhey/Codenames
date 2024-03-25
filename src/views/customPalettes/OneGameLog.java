package views.customPalettes;

import models.Player;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class OneGameLog extends JPanel {

    public OneGameLog(Player player, String role, Color bgColor, Color containerColor) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        LabelBox playerNicknameLabel = new LabelBox(player.getNickname(), bgColor, Color.WHITE, new Dimension(100, 30));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(playerNicknameLabel, gridBagConstraints);

        LabelBox roleLabel = new LabelBox(role, bgColor, Color.BLACK, new Dimension(135, 30));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(-6, 0, 0, 0);
        add(roleLabel, gridBagConstraints);

        ContainerPanel containerPanel = new ContainerPanel(containerColor, new Dimension(208, 235));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(-6, 0, 0, 0);
        add(containerPanel, gridBagConstraints);
    }



}

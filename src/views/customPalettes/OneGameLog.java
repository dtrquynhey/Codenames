package views.customPalettes;

import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class OneGameLog extends JPanel {

    public OneGameLog(String player, String role, Color bgColor) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        LabelBox roleLabel = new LabelBox(role, bgColor, Color.BLACK, new Dimension(135, 40));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(roleLabel, gridBagConstraints);

        Label playerNicknameLabel = new Label(player, Font.BOLD, 18, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(2, 0, 5, 0);
        add(playerNicknameLabel, gridBagConstraints);
    }






}

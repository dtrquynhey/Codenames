package views.customPalettes;

import javax.swing.*;
import java.awt.*;

public class OneGameLog extends JPanel {

    public OneGameLog(String player, String role, Color bgColor) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        LabelBox playerNicknameLabel = new LabelBox(player, bgColor, Color.WHITE, new Dimension(100, 30));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(playerNicknameLabel, gridBagConstraints);

        LabelBox roleLabel = new LabelBox(role, bgColor, Color.BLACK, new Dimension(135, 30));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(-6, 0, 0, 0);
        add(roleLabel, gridBagConstraints);
    }






}

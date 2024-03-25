package views.customPalettes;

import models.enums.Role;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class BlueTeamGameLog extends JPanel {

    public BlueTeamGameLog(Map<Role, String> blueTeam) {
        setLayout(new GridBagLayout());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        OneGameLog spymasterBlueGameLog = new OneGameLog(blueTeam.get(Role.SPYMASTER), Role.SPYMASTER.toString(), CustomColor.BLUE_COMBOBOX.getColor(), Color.decode("#735662"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(spymasterBlueGameLog, gridBagConstraints);

        OneGameLog operativeBlueGameLog = new OneGameLog(blueTeam.get(Role.OPERATIVE), Role.OPERATIVE.toString(), CustomColor.BLUE_COMBOBOX.getColor(), Color.decode("#735662"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(2, 0, 0, 0);
        add(operativeBlueGameLog, gridBagConstraints);

        Label blueScore = new Label("SCORE", Font.BOLD, 18, CustomColor.TEXT_WHITE.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);

        add(blueScore, gridBagConstraints);
    }

    public void setBackgroundColor(Color color) {
        setBackground(color);
    }
}

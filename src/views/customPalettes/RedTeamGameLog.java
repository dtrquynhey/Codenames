package views.customPalettes;

import models.Player;
import models.enums.Role;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class RedTeamGameLog extends JPanel {

    public RedTeamGameLog(Map<Role, Player> redTeam) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        OneGameLog spymasterRedGameLog = new OneGameLog(redTeam.get(Role.SPYMASTER), Role.SPYMASTER.toString(), CustomColor.RED_COMBOBOX.getColor(), Color.decode("#823E36"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(spymasterRedGameLog, gridBagConstraints);

        OneGameLog operativeRedGameLog = new OneGameLog(redTeam.get(Role.OPERATIVE), Role.OPERATIVE.toString(), CustomColor.RED_COMBOBOX.getColor(), Color.decode("#823E36"));
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(2, 0, 0, 0);
        add(operativeRedGameLog, gridBagConstraints);

        Label redScore = new Label("SCORE", Font.BOLD, 18, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        add(redScore, gridBagConstraints);
    }

    public void setBackgroundColor(Color color) {
        setBackground(color);
    }
}

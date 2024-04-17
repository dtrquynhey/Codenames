package views.customPalettes;

import controllers.GameController;
import controllers.TeamController;
import models.Player;
import models.enums.Role;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class RedTeamGameLog extends JPanel {

    public RedTeamGameLog(GameController gameController) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        OneGameLog spymasterRedGameLog = new OneGameLog(gameController.getGame().getTeams().getFirst().getSpymaster(), Role.SPYMASTER.toString(), CustomColor.RED_COMBOBOX.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(spymasterRedGameLog, gridBagConstraints);

        OneGameLog operativeRedGameLog = new OneGameLog(gameController.getGame().getTeams().getFirst().getOperative(), Role.OPERATIVE.toString(), CustomColor.RED_COMBOBOX.getColor());
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
}

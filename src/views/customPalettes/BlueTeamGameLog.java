package views.customPalettes;

import controllers.GameController;
import models.enums.Role;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class BlueTeamGameLog extends JPanel {

    private final Label labelScore;

    public BlueTeamGameLog(GameController gameController) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        OneGameLog spymasterBlueGameLog = new OneGameLog(gameController.getGame().getTeams().get(1).getSpymaster(), Role.SPYMASTER.toString(), CustomColor.BLUE_COMBOBOX.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(spymasterBlueGameLog, gridBagConstraints);

        OneGameLog operativeBlueGameLog = new OneGameLog(gameController.getGame().getTeams().get(1).getOperative(), Role.OPERATIVE.toString(), CustomColor.BLUE_COMBOBOX.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        add(operativeBlueGameLog, gridBagConstraints);

        Label label1 = new Label("Score: ", Font.BOLD, 16, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        add(label1, gridBagConstraints);

        labelScore = new Label("0", Font.BOLD, 18, CustomColor.TEXT.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new Insets(2, 0, 0, 0);
        add(labelScore, gridBagConstraints);
    }

    public void setScore(int score) {
        this.labelScore.setText(String.valueOf(score));
    }

}

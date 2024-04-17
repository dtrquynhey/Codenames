package views.customPalettes;

import controllers.GameController;
import models.enums.Role;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class RedTeamGameLog extends JPanel {


    private Label labelScore;

    public RedTeamGameLog(GameController gameController) {
        setLayout(new GridBagLayout());
        setBackground(new Color(0, 0, 0, 0));

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        OneGameLog spymasterRedGameLog = new OneGameLog(gameController.getGame().getTeams().getFirst().getSpymaster(), Role.SPYMASTER.toString(), CustomColor.RED_COMBOBOX.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        add(spymasterRedGameLog, gridBagConstraints);

        OneGameLog operativeRedGameLog = new OneGameLog(gameController.getGame().getTeams().getFirst().getOperative(), Role.OPERATIVE.toString(), CustomColor.RED_COMBOBOX.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(5, 0, 0, 0);
        add(operativeRedGameLog, gridBagConstraints);

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

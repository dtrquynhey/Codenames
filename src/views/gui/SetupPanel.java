package views.gui;

import controllers.TeamController;
import views.customPalettes.*;
import views.customPalettes.enums.CustomColor;

import java.awt.*;

public class SetupPanel extends MainPanel {

    public SetupPanel(TeamController teamController, String[] playerNicknames) {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        RoundedButton buttonLogOut = new RoundedButton("Log Out", 110, 42, CustomColor.RED.getColor());
        topFlowPanel.add(buttonLogOut);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        RolesChooserPanel rolesChooserPanel = new RolesChooserPanel(playerNicknames);
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(rolesChooserPanel, gridBagConstraints);

        RoundedButton buttonRandomize = new RoundedButton("Randomize", 145, 42, CustomColor.LIGHT_YELLOW.getColor());
        bottomFlowPanel.add(buttonRandomize);

        RoundedButton buttonStartGame = new RoundedButton("Start Game", 145, 42, CustomColor.GREEN.getColor());
        bottomFlowPanel.add(buttonStartGame);

        buttonStartGame.addActionListener(e -> {
            if (!teamController.isValidRoom(rolesChooserPanel.getSelectedPlayers())) {
                new MessageDialog(this, "Each player can only play one role.", "Team Selection Error");
            } else {
                teamController.setupTeams(rolesChooserPanel.getPlayerSelectedTeams());
                new MessageDialog(this, "All teams are set", "Team Selection Success");
            }
        });
    }



}

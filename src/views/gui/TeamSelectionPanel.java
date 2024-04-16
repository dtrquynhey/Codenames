package views.gui;

import controllers.GameController;
import controllers.TeamController;
import views.customPalettes.*;
import views.customPalettes.Panel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class TeamSelectionPanel extends Panel {

    private final RolesChooserPanel rolesChooserPanel;

    public TeamSelectionPanel(GameController gameController, TeamController teamController) {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        RoundedButton buttonLogOut = new RoundedButton("Log Out", 110, 42, CustomColor.RED.getColor());
        topFlowPanel.add(buttonLogOut);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        rolesChooserPanel = new RolesChooserPanel(gameController.getGame().getPlayers());
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(rolesChooserPanel, gridBagConstraints);

        RoundedButton buttonRandomize = new RoundedButton("Randomize", 145, 42, CustomColor.LIGHT_YELLOW.getColor());
        bottomFlowPanel.add(buttonRandomize);

        RoundedButton buttonStartGame = new RoundedButton("Start Game", 145, 42, CustomColor.GREEN.getColor());
        bottomFlowPanel.add(buttonStartGame);

        buttonStartGame.addActionListener(e -> {
            if (!teamController.isValidRoom(rolesChooserPanel.getComboBoxSelectedPlayers())) {
                new MessageDialog(this, "Each player can only play one role.", "Team Setup Error");
            } else {
                teamController.setupTeams(rolesChooserPanel.getPlayerSelectedTeams());
                new MessageDialog(this, "All teams are set.", "Team Setup Success");
                showGamePlayPanel();
            }
        });
        buttonRandomize.addActionListener(e->{
            teamController.randomizeRolesAndTeams(gameController.getGame().getPlayers()); // Randomize the roles
            rolesChooserPanel.updateRoleChoosers(teamController.getRandomizedPlayerSelectedTeams()); // Update the UI

        });
    }

    private void showGamePlayPanel() {
        GamePlayPanel gamePlayPanel = new GamePlayPanel(rolesChooserPanel.getPlayerSelectedTeams());
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(TeamSelectionPanel.this);
        mainFrame.showPanel(gamePlayPanel);
    }


}

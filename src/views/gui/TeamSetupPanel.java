package views.gui;

import controllers.GameController;
import controllers.TeamController;
import views.customPalettes.*;
import views.customPalettes.Panel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class TeamSetupPanel extends Panel {

    private final RolesChooserPanel rolesChooserPanel;
    private GameController gameController;

    public TeamSetupPanel(GameController gameController, TeamController teamController) {
        super();
        this.gameController = gameController;
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
                new MessageDialog(this, "Each player can only play one role.", "Team Setup Error", "Try Again");
            } else {
                teamController.setTeams(rolesChooserPanel.getPlayerSelectedTeamsMap());
                gameController.getGame().setTeams(teamController.getTeams());
                gameController.setInitialTeam();
                showGamePlayPanel();
            }
        });
        buttonRandomize.addActionListener(e -> {
            teamController.randomizeRolesAndTeams(gameController.getGame().getPlayers()); // Randomize the roles
            rolesChooserPanel.updateRoleChoosers(teamController.getRandomizedPlayerSelectedTeams()); // Update the UI
        });
    }

    private void showGamePlayPanel() {
        GamePlayPanel gamePlayPanel = new GamePlayPanel(this.gameController);
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(TeamSetupPanel.this);
        mainFrame.showPanel(gamePlayPanel);
    }


}

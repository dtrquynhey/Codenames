package views.gui;

import controllers.PlayerController;
import controllers.TeamController;
import models.Player;
import views.customPalettes.*;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TeamSetupPanel extends Panel {

    private RolesChooserPanel rolesChooserPanel;

    public TeamSetupPanel(TeamController teamController, PlayerController playerController) {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        RoundedButton buttonLogOut = new RoundedButton("Log Out", 110, 42, CustomColor.RED.getColor());
        topFlowPanel.add(buttonLogOut);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        rolesChooserPanel = new RolesChooserPanel(playerController.getPlayerList());
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
            teamController.randomizeRolesAndTeams(playerController.getPlayerList()); // Randomize the roles
            rolesChooserPanel.updateRoleChoosers(teamController.getRandomizedPlayerSelectedTeams()); // Update the UI

        });
    }

    private void showGamePlayPanel() {

//        Connection connection;
//        try {
//            connection = DbConfig.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        TeamRepository teamRepository = new TeamRepository(connection, new TeamMapper());
//        TeamController teamController = TeamController.getInstance(teamRepository);
        GamePlayPanel gamePlayPanel = new GamePlayPanel(rolesChooserPanel.getPlayerSelectedTeams());
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(TeamSetupPanel.this);
        mainFrame.showPanel(gamePlayPanel);
    }


}

package views.gui;

import controllers.AccountController;
import controllers.GameController;
import controllers.TeamController;
import views.customPalettes.*;
import views.customPalettes.Label;
import views.customPalettes.Panel;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;

public class TeamSetupPanel extends Panel {

    private final RolesChooserPanel rolesChooserPanel;
    private final GameController gameController;

    public TeamSetupPanel(GameController gameController, TeamController teamController) {
        super();
        this.gameController = gameController;
        AccountController accountController = AccountController.getInstance();
        Label loggedAccountLabel = new Label("Logged in as: " + accountController.getAccount(), Font.BOLD, 16, CustomColor.TEXT.getColor());
        topFlowPanel.add(loggedAccountLabel);

//        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.YELLOW.getColor().darker());
//        topFlowPanel.add(buttonReadRules);

        RoundedButton buttonExitGame = new RoundedButton("Exit Game", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonExitGame);

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
        buttonExitGame.addActionListener(e -> {
            HomePanel homePanel = new HomePanel(AccountController.getInstance());
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(TeamSetupPanel.this);
            mainFrame.showPanel(homePanel);
        });
    }

    private void showGamePlayPanel() {
        GamePlayPanel gamePlayPanel = new GamePlayPanel(this.gameController);
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(TeamSetupPanel.this);
        mainFrame.showPanel(gamePlayPanel);
    }
}

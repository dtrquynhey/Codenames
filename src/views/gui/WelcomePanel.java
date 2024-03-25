package views.gui;

import controllers.PlayerController;
import controllers.TeamController;
import repositories.DbConfig;
import repositories.TeamRepository;
import repositories.mappers.TeamMapper;
import views.customPalettes.*;
import views.customPalettes.enums.CustomColor;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class WelcomePanel extends MainPanel {

    private SetupPanel setupPanel;

    public WelcomePanel(PlayerController playerController) {
        super();

        RoundedButton buttonReadRules = new RoundedButton("Read Rules", 140, 42, CustomColor.GREY.getColor());
        topFlowPanel.add(buttonReadRules);

        RoundedButton buttonLogOut = new RoundedButton("Log Out", 110, 42, CustomColor.RED.getColor());
        topFlowPanel.add(buttonLogOut);

        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        ShadowLabel labelTitle = new ShadowLabel("CODENAMES", 100, CustomColor.TEXT_WHITE.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 0, 10, 0);
        centerGridBagPanel.add(labelTitle,gridBagConstraints);


        PlayersNamePanel playersNamePanel = new PlayersNamePanel();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        centerGridBagPanel.add(playersNamePanel, gridBagConstraints);

        RoundedButton buttonCreateRoom = new RoundedButton("Create Room", 160, 42, CustomColor.PINK.getColor());
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new Insets(15, 0, 0, 0);
        centerGridBagPanel.add(buttonCreateRoom, gridBagConstraints);

        buttonCreateRoom.addActionListener(e -> {
            String[] playerNicknames = playersNamePanel.getPlayerNicknames();
            switch (playerController.createNewRoom(playerNicknames)) {
                case MISSING_PLAYERS -> playersNamePanel.showError("All player nicknames are required.");
                case DUPLICATE_NAMES -> playersNamePanel.showError("Nicknames must be unique.");
                case SUCCESS -> {
                    showSetupPanel(playerNicknames);
                }
            }

        });

        buttonReadRules.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
            mainFrame.showRulesPanel();
        });

        buttonLogOut.addActionListener(e -> {
            MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
            mainFrame.showLoginPanel();
        });

    }

    public void showSetupPanel(String[] playerNicknames) {

        Connection connection;
        try {
            connection = DbConfig.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        TeamRepository teamRepository = new TeamRepository(connection, new TeamMapper());
        TeamController teamController = TeamController.getInstance(teamRepository);
        setupPanel = new SetupPanel(teamController, playerNicknames);
        MainFrame mainFrame = (MainFrame) SwingUtilities.getWindowAncestor(WelcomePanel.this);
        mainFrame.showPanel(setupPanel);
    }

    private void showError(IconLabelPanel labelError, String errorMessage) {
        labelError.setVisible(true);
        labelError.setMessageLabel(errorMessage);
    }

}

package controllers;

import contracts.IPlayerContract;
import controllers.enums.RoomCreationResult;
import models.Player;
import repositories.DbConfig;
import repositories.TeamRepository;
import repositories.mappers.TeamMapper;
import views.gui.TeamSetupPanel;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerController implements IPlayerContract {

    private static PlayerController instance;
    private List<Player> players = new ArrayList<>();

    public PlayerController() {
    }


    public static PlayerController getInstance() {

        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(String[] usernames) {
        for (String u : usernames) {
            this.players.add(new Player(u));
        }
    }

    @Override
    public RoomCreationResult isValidNicknames(String[] nicknames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : nicknames) {
            if (name == null || name.trim().isEmpty()) {
                return RoomCreationResult.MISSING_NAMES;
            }
            if (uniqueNames.contains(name)) {
                return RoomCreationResult.DUPLICATE_NAMES;
            }
            uniqueNames.add(name);
        }
        return RoomCreationResult.SUCCESS;
    }

    public TeamSetupPanel initializeTeamSetUpPanel(GameController gameController) {
        Connection connection = DbConfig.getConnection();
        TeamRepository teamRepository = new TeamRepository(connection, new TeamMapper());
        TeamController teamController = TeamController.getInstance(teamRepository);
        return new TeamSetupPanel(gameController, teamController);
    }

}

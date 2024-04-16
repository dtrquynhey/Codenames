package controllers;

import contracts.IPlayerContract;
import controllers.enums.RoomCreationResult;
import models.Account;
import models.Player;
import repositories.DbConfig;
import repositories.TeamRepository;
import repositories.mappers.TeamMapper;
import views.gui.TeamSelectionPanel;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerController implements IPlayerContract {

    private static PlayerController instance;
    public int playerIndex;
    private List<Player> players = new ArrayList<>();

    public PlayerController() {
    }

    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayerList(List<Account> accounts, List<Player> guests) {

    }
    public static PlayerController getInstance() {

        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }

    @Override
    public void createPlayers(String[] usernames) {
        for (String u : usernames) {
            this.players.add(new Player(u));
        }
    }

    @Override
    public RoomCreationResult isValidPlayerNames(String[] playerNicknames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : playerNicknames) {
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

    public TeamSelectionPanel initializeTeamSetUpPanel(GameController gameController) {
        Connection connection = DbConfig.getConnection();
        TeamRepository teamRepository = new TeamRepository(connection, new TeamMapper());
        TeamController teamController = TeamController.getInstance(teamRepository);
        return new TeamSelectionPanel(gameController, teamController);
    }

}

package controllers;

import contracts.IPlayerContract;
import controllers.enums.RoomCreationResult;
import models.Account;
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
    public int playerIndex;
    private List<Player> players = new ArrayList<>();

    public PlayerController() {
    }

    public List<Player> getPlayerList() {
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

    public void addGuestPlayer(String username) {
        players.add(playerIndex, new Player(username));
    }

    public void addLoggedPlayer(Account account) {
        players.add(playerIndex, new Player(account));
    }

    @Override
    public void createRoom(List<Account> accounts) {
        List<Player> players = new ArrayList<>(4);
        for (Account a : accounts) {
            players.add(new Player(a));
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

    public TeamSetupPanel initializeTeamSetUpPanel() {
        Connection connection = DbConfig.getConnection();
        TeamRepository teamRepository = new TeamRepository(connection, new TeamMapper());
        TeamController teamController = TeamController.getInstance(teamRepository);
        return new TeamSetupPanel(teamController, getInstance());
    }

}

package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import contracts.ITeamContract;
import models.Player;
import models.Team;
import models.enums.Color;
import models.enums.Role;
import repositories.TeamRepository;

import java.sql.SQLException;
import java.util.*;

public class TeamController implements ITeamContract {

    private static TeamController instance;
    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public static TeamController getInstance(TeamRepository teamRepository) {

        if (instance == null) {
            instance = new TeamController(teamRepository);
        }
        return instance;
    }

    @Override
    public void setupTeams(Map<Color, Map<Role, String>> playerSelectedTeams) {
        Team redTeam = new Team(getPlayerListFromMap(playerSelectedTeams, Color.RED), Color.RED, 0, 0);
        Team blueTeam = new Team(getPlayerListFromMap(playerSelectedTeams, Color.BLUE), Color.BLUE, 0, 0);
        try {
            teamRepository.createTeam(redTeam);
            teamRepository.createTeam(blueTeam);
        } catch (SQLException | JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isValidRoom(String[] players) {

        Set<String> uniqueRoles = new HashSet<>(Arrays.asList(players));
        return uniqueRoles.size() == players.length;
    }

    private List<Player> getPlayerListFromMap(Map<Color, Map<Role, String>> playerSelectedTeams, Color color) {
        List<Player> players = new ArrayList<>();
        Map<Role, String> playerRoles = playerSelectedTeams.get(color);
        for (Map.Entry<Role, String> entry : playerRoles.entrySet()) {
            Player player = new Player(entry.getValue());
            players.add(player);
        }
        return players;
    }

}

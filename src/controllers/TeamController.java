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
    public void setupTeams(Map<Color, Map<Role, Player>> playerSelectedTeams) {
        Team redTeam = new Team(getPlayerByColorRole(playerSelectedTeams, Color.RED, Role.SPYMASTER),
                getPlayerByColorRole(playerSelectedTeams, Color.BLUE, Role.SPYMASTER),
                Color.RED, false);
        Team blueTeam = new Team(getPlayerByColorRole(playerSelectedTeams, Color.BLUE, Role.SPYMASTER),
                getPlayerByColorRole(playerSelectedTeams, Color.BLUE, Role.SPYMASTER),
                Color.BLUE, false);
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

    @Override
    public void randomizeRolesAndTeams(List<Player> players) {
        Collections.shuffle(players);
        int halfSize = players.size() /2;
        Map<Color, Map<Role, Player>> playerSelectedTeams = new HashMap<>();
        playerSelectedTeams.put(Color.RED, new HashMap<>());
        playerSelectedTeams.put(Color.BLUE, new HashMap<>());

        // Assign one SPYMASTER and OPERATIVES to each team
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            Color teamColor = i < halfSize ? Color.RED : Color.BLUE;
            Role playerRole;

            // First player in each team becomes SPYMASTER, others are OPERATIVES
            if (i == 0 || i == halfSize) {
                playerRole = Role.SPYMASTER;
            } else {
                playerRole = Role.OPERATIVE;
            }

            // Assign player to their team and role
            Map<Role, Player> teamRoles = playerSelectedTeams.get(teamColor);
            teamRoles.put(playerRole, player);
        }

        // Setup teams with the randomized players and roles
        setupTeams(playerSelectedTeams);
    }


    // Function to get all players by team color
    private Map<Role, Player> getPlayersByColor(Map<Color, Map<Role, Player>> playerSelectedTeams, Color color) {
        Map<Role, Player> playersByRole = new HashMap<>();
        Map<Role, Player> playerRoles = playerSelectedTeams.get(color);
        if (playerRoles != null) {
            playersByRole.putAll(playerRoles);
        }
        return playersByRole;
    }

    // Function to get player by role for a specific team color
    private Player getPlayerByColorRole(Map<Color, Map<Role, Player>> playerSelectedTeams, Color color, Role role) {
        Map<Role, Player> playerRoles = getPlayersByColor(playerSelectedTeams, color);
        return playerRoles.get(role);// Player not found for the given role
    }

}

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
    private Map<Color, Map<Role, Player>> randomizedPlayerSelectedTeams;


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
                getPlayerByColorRole(playerSelectedTeams, Color.RED, Role.OPERATIVE),
                Color.RED, false);

        Team blueTeam = new Team(getPlayerByColorRole(playerSelectedTeams, Color.BLUE, Role.SPYMASTER),
                getPlayerByColorRole(playerSelectedTeams, Color.BLUE, Role.OPERATIVE),
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
        List<Role> roles = Arrays.asList(Role.SPYMASTER, Role.SPYMASTER, Role.OPERATIVE, Role.OPERATIVE);
        Collections.shuffle(roles);
        randomizedPlayerSelectedTeams = new HashMap<>();

        randomizedPlayerSelectedTeams.put(Color.RED, new HashMap<>());
        randomizedPlayerSelectedTeams.put(Color.BLUE, new HashMap<>());

        for (int i = 0; i < players.size(); i++) {
            Color teamColor = (i % 2 == 0) ? Color.RED : Color.BLUE;
            randomizedPlayerSelectedTeams.get(teamColor).put(roles.get(i), players.get(i));
        }
    }
    public Map<Color, Map<Role, Player>> getRandomizedPlayerSelectedTeams() {
        return randomizedPlayerSelectedTeams;
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

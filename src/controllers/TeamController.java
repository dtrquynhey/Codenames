package controllers;

import contracts.ITeamContract;
import models.Player;
import models.Team;
import models.enums.Color;
import models.enums.Role;

import java.util.*;

public class TeamController implements ITeamContract {

    private List<Team> teams;

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(Map<Color, Map<Role, Player>> playerSelectedTeams) {
        Team redTeam = new Team(getPlayerByColorRole(playerSelectedTeams, Color.RED, Role.SPYMASTER),
                getPlayerByColorRole(playerSelectedTeams, Color.RED, Role.OPERATIVE),
                Color.RED);

        Team blueTeam = new Team(getPlayerByColorRole(playerSelectedTeams, Color.BLUE, Role.SPYMASTER),
                getPlayerByColorRole(playerSelectedTeams, Color.BLUE, Role.OPERATIVE),
                Color.BLUE);
        this.teams = new ArrayList<>(2);
        teams.add(redTeam);
        teams.add(blueTeam);
    }

    private Map<Color, Map<Role, Player>> randomizedPlayerSelectedTeams;


    public TeamController() {
    }

    @Override
    public boolean isValidRoom(String[] players) {

        Set<String> uniqueRoles = new HashSet<>(Arrays.asList(players));
        return uniqueRoles.size() == players.length;
    }

    public void randomizeRolesAndTeams(List<Player> players) {
        if (players.size() < 4) {
            throw new IllegalArgumentException("Not enough players for the roles defined");
        }

        Collections.shuffle(players);

        randomizedPlayerSelectedTeams = new HashMap<>();
        randomizedPlayerSelectedTeams.put(Color.RED, new HashMap<>());
        randomizedPlayerSelectedTeams.put(Color.BLUE, new HashMap<>());

        // Arrays to keep track of how many roles have been assigned to each team
        int redSpymasters = 0, blueSpymasters = 0, redOperatives = 0, blueOperatives = 0;

        for (int i = 0; i < players.size(); i++) {
            Color teamColor = (i % 2 == 0) ? Color.RED : Color.BLUE;
            Role role;

            // Determine role based on current counts
            if (teamColor == Color.RED) {
                if (redSpymasters < 1) {
                    role = Role.SPYMASTER;
                    redSpymasters++;
                } else if (redOperatives < 1) {
                    role = Role.OPERATIVE;
                    redOperatives++;
                } else {
                    // If extra players, decide what to do or skip assigning roles
                    continue;
                }
            } else {
                if (blueSpymasters < 1) {
                    role = Role.SPYMASTER;
                    blueSpymasters++;
                } else if (blueOperatives < 1) {
                    role = Role.OPERATIVE;
                    blueOperatives++;
                } else {
                    // If extra players, decide what to do or skip assigning roles
                    continue;
                }
            }

            // Assign player to the determined role and team
            randomizedPlayerSelectedTeams.get(teamColor).put(role, players.get(i));
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

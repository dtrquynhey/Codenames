package repositories.mappers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Player;
import models.Team;
import models.enums.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Team mapFromResultSet(ResultSet resultSet) throws SQLException, JsonProcessingException {
        String playersJson = resultSet.getString("players");
        List<Player> listOfPlayers = mapPlayers(playersJson);
        Color color = Color.valueOf(resultSet.getString("color"));
        int score = resultSet.getInt("score");
        int numOfGuess = resultSet.getInt("numOfGuess");
        return new Team(listOfPlayers, color, score, numOfGuess);
    }

    public void mapToPreparedStatement(Team team, PreparedStatement statement) throws SQLException, JsonProcessingException {
        statement.setString(1, convertPlayerListToJson(team.getListOfPlayers()));
        statement.setString(2, team.getColor().toString());
        statement.setInt(3, team.getScore());
        statement.setInt(4, team.getNumOfGuess());
    }

    private List<Player> mapPlayers(String playersJson) throws JsonProcessingException {
        List<Player> listOfPlayers = new ArrayList<>();
        // Convert JSON string to list of players
        Player[] playersArray = objectMapper.readValue(playersJson, Player[].class);
        Collections.addAll(listOfPlayers, playersArray);
        return listOfPlayers;
    }

    private String convertPlayerListToJson(List<Player> players) throws JsonProcessingException {
        // Convert list of players to JSON string
        return objectMapper.writeValueAsString(players);
    }
}

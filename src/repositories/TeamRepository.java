package repositories;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.Team;
import repositories.mappers.TeamMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TeamRepository {

    private final Connection connection;
    private final TeamMapper teamMapper;

    public TeamRepository(Connection connection, TeamMapper teamMapper) {
        this.connection = connection;
        this.teamMapper = teamMapper;
    }

    public void createTeam(Team team) throws SQLException, JsonProcessingException {
        String insertQuery = "INSERT INTO teams (players, color, score, numOfGuess) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            teamMapper.mapToPreparedStatement(team, statement);
            statement.executeUpdate();
        }
    }
}

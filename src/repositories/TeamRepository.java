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

    public void insertTeam(Team team) {
        String insertQuery = "INSERT INTO teams (spymaster, operative, color, isWinner) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            teamMapper.mapToPreparedStatement(team, statement);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

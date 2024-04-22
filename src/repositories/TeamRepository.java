package repositories;

import models.Team;

import java.sql.*;

public class TeamRepository {

    private final Connection connection;

    public TeamRepository() {
        this.connection = DbConfig.getConnection();
    }

    public int insertTeamAndGetId(Team team) {
        String insertQuery = "INSERT INTO teams (spymaster, operative, color, isWinner) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, team.getSpymaster());
            statement.setString(2, team.getOperative());
            statement.setString(3, team.getColor().toString());
            statement.setBoolean(4, team.isWinner());
            statement.executeUpdate();
            try (ResultSet resultSet = statement.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    throw new SQLException("Failed to retrieve auto-generated teamId.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

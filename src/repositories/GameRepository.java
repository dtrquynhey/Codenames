package repositories;

import models.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private final Connection connection;
    private final TeamRepository teamRepository;

    public GameRepository() {
        this.connection = DbConfig.getConnection();
        this.teamRepository = new TeamRepository();
    }

    public int insertGame(Game game) {
        String insertQuery = "INSERT INTO games (redTeam, blueTeam, date, result) VALUES (?, ?, ?, ?)";

        try {

            int redTeamId = teamRepository.insertTeamAndGetId(game.getRedTeam());
            int blueTeamId = teamRepository.insertTeamAndGetId(game.getBlueTeam());

            try (PreparedStatement statement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)) {

                statement.setInt(1, redTeamId);
                statement.setInt(2, blueTeamId);
                statement.setDate(3, java.sql.Date.valueOf(game.getDate()));
                statement.setString(4, game.getGameResult().toString());
                statement.executeUpdate();
                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        return resultSet.getInt(1);
                    } else {
                        throw new SQLException("Failed to retrieve auto-generated teamId.");
                    }
                }
            }
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

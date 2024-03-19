package repositories;

import models.Player;
import repositories.mappers.PlayerMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PlayerRepository {

    private final Connection connection;
    private final PlayerMapper playerMapper;

    public PlayerRepository(Connection connection, PlayerMapper playerMapper) {
        this.connection = connection;
        this.playerMapper = playerMapper;
    }

    public void createPlayer(Player player) throws SQLException {
        String insertQuery = "INSERT INTO players (nickname) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            playerMapper.mapToPreparedStatement(player, statement);
            statement.executeUpdate();
        }
    }

}

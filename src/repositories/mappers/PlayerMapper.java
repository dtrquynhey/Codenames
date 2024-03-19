package repositories.mappers;

import models.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerMapper {

    public Player mapFromResultSet(ResultSet resultSet) throws SQLException {
        String nickname = resultSet.getString("nickname");
        return new Player(nickname);
    }

    public void mapToPreparedStatement(Player player, PreparedStatement statement) throws SQLException {
        statement.setString(1, player.getNickname());
    }
}

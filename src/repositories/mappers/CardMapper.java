package repositories.mappers;

import models.Card;
import models.enums.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardMapper {

    public Card mapFromResultSet(ResultSet resultSet) throws SQLException {
        String word = resultSet.getString("word");
        Color color = Color.valueOf(resultSet.getString("color"));
        Boolean isRevealed = Boolean.valueOf(resultSet.getString("isRevealed"));
        return new Card(word, color, isRevealed);
    }

    public void mapToPreparedStatement(Card card, PreparedStatement statement) throws SQLException {
        statement.setString(1, card.getWord());
        statement.setString(2, card.getColor().toString());
        statement.setBoolean(3, card.getIsRevealed());
    }
}

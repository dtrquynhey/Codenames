package repositories;

import models.Card;
import repositories.mappers.CardMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CardRepository {

    private final Connection connection;
    private final CardMapper cardMapper;

    public CardRepository(Connection connection, CardMapper cardMapper) {
        this.connection = connection;
        this.cardMapper = cardMapper;
    }

    public void createCard(Card card) throws SQLException {
        String insertQuery = "INSERT INTO cards (word) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            cardMapper.mapToPreparedStatement(card, statement);
            statement.executeUpdate();
        }
    }


}

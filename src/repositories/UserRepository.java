package repositories;

import models.User;
import repositories.mappers.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final Connection connection;
    private final UserMapper userMapper;

    public UserRepository(Connection connection, UserMapper userMapper) {
        this.connection = connection;
        this.userMapper = userMapper;
    }

    public void createUser(User user) throws SQLException {
        String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            userMapper.mapInsertStatement(user, statement);
            statement.executeUpdate();
        }
    }

    public boolean isUniqueUsername(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;
    }

}

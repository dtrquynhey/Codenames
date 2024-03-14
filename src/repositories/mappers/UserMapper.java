package repositories.mappers;

import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    // Map a ResultSet to a User object
    public User mapFromResultSet(ResultSet resultSet) throws SQLException {
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        return new User(username, password);
    }

    // Map a User object to a PreparedStatement
    public void mapToPreparedStatement(User user, PreparedStatement statement) throws SQLException {
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
    }
}

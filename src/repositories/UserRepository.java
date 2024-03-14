package repositories;

import models.User;
import repositories.mappers.UserMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Repositories: tool for the BACKEND side to communicate with the DATABASE side
// WhateverRepository execute INSERT UPDATE DELETE SELECT to `Whatever` table in the database
public class UserRepository {

    private final Connection connection;
    private final UserMapper userMapper;

    public UserRepository(Connection connection, UserMapper userMapper) {
        this.connection = connection;
        this.userMapper = userMapper;
    }

    // INSERT INTO users (SignUp)
    public void createUser(User user) throws SQLException {
        String insertQuery = "INSERT INTO users (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            userMapper.mapToPreparedStatement(user, statement);
            statement.executeUpdate();
        }
    }

    // SELECT * FROM users WHERE username = ?
    public boolean findUserByUsername (String username) throws SQLException {
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

    // SELECT * FROM users WHERE username = ? AND password = ?
    public User findUserByUsernameAndPassword(String username, String password) throws SQLException {
        // TODO: (DONE) First. findUserByUsernameAndPassword
        // Connect to the database and look through the table for the user with the given username and password
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return userMapper.mapFromResultSet(resultSet);
                }
            }
        }
        return null; // User not found or incorrect password
    }


}

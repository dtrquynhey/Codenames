package repositories;

import models.Account;
import repositories.mappers.AccountMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Repositories: tool for the BACKEND side to communicate with the DATABASE side
// WhateverRepository execute INSERT UPDATE DELETE SELECT to `Whatever` table in the database
public class AccountRepository {

    private final Connection connection;
    private final AccountMapper accountMapper;

    public AccountRepository(Connection connection, AccountMapper accountMapper) {
        this.connection = connection;
        this.accountMapper = accountMapper;
    }

    // INSERT INTO accounts (SignUp)
    public void insertAccount(Account account) throws SQLException {
        String insertQuery = "INSERT INTO accounts (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            accountMapper.mapToPreparedStatement(account, statement);
            statement.executeUpdate();
        }
    }

    // SELECT * FROM accounts WHERE username = ?
    public boolean findAccount(String username) throws SQLException {
        String query = "SELECT COUNT(*) FROM accounts WHERE username = ?";
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

    // SELECT * FROM accounts WHERE username = ? AND password = ?
    public boolean findAccount(String username, String password) throws SQLException {

        // Connect to the database and look through the table for the user with the given username and password
        String query = "SELECT COUNT(*) FROM accounts WHERE username = ? AND password = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, password);
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

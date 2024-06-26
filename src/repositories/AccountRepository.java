package repositories;

import models.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Repositories: tool for the BACKEND side to communicate with the DATABASE side
// WhateverRepository execute INSERT UPDATE DELETE SELECT to `Whatever` table in the database
public class AccountRepository {

    private final Connection connection;

    public AccountRepository() {
        this.connection = DbConfig.getConnection();
    }

    // INSERT INTO accounts (SignUp)
    public void insertAccount(Account account) {
        String insertQuery = "INSERT INTO accounts (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setString(1, account.getUsername());
            statement.setString(2, account.getPassword());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // DELETE FROM accounts WHERE username = ?
    public void deleteAccount(String username) {
        String deleteQuery = "DELETE FROM accounts WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
            statement.setString(1, username);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // SELECT * FROM accounts WHERE username = ?
    public boolean findAccount(String username) {
        String query = "SELECT COUNT(*) FROM accounts WHERE username = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    // SELECT * FROM accounts WHERE username = ? AND password = ?
    public boolean findAccount(String username, String password) {

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}

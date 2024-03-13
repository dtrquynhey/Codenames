package controllers;

import contracts.UserContract;
import models.User;
import repositories.UserRepository;

import java.sql.SQLException;

public class UserController implements UserContract {

    private static UserController instance;
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static UserController getInstance(UserRepository userRepository) {

        if (instance == null) {
            instance = new UserController(userRepository);
        }
        return instance;
    }

    @Override
    public AuthenticationResult registerUser(String username, String password, String confirmedPassword) {

        if (username.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) {
            return AuthenticationResult.EMPTY_FIELDS;

        } else if (!password.equals(confirmedPassword)) {
            return AuthenticationResult.PASSWORD_MISMATCH;

        } else if (isUniqueUsername(username)) {
            return AuthenticationResult.EXISTING_USER;

        } else {
            try {
                User user = new User(username, password);
                userRepository.createUser(user);
                return AuthenticationResult.SUCCESS;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public AuthenticationResult logUserIn(String username, String password) {
        return null;
    }

    public boolean isUniqueUsername(String username) {
        try {
            return userRepository.isUniqueUsername(username);
        } catch (SQLException e) {
            throw new RuntimeException("Error checking is username is unique", e);
        }
    }
}

package controllers;

import contracts.UserContract;
import controllers.enums.AuthenticationResult;
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

    // registerUser() validates the input parameters and returns whether they are valid
    // Then, the receiver (SignupPanel.buttonSignUp) will act upon the return result
    @Override
    public AuthenticationResult registerUser(String username, String password, String confirmedPassword) {

        if (username.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) {
            return AuthenticationResult.EMPTY_FIELDS;

        } else if (isUniqueUsername(username)) {
            return AuthenticationResult.EXISTING_USER;

        } else if (!password.equals(confirmedPassword)) {
            return AuthenticationResult.PASSWORD_MISMATCH;

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

    // logUserIn() validates the input and returns whether they are valid
    // Then, the receiver (LoginPanel.buttonLogIn) will act upon the return result
    @Override
    public AuthenticationResult logUserIn(String username, String password) {
        // TODO: Third. logUserIn()
        // UserController implements the Login contract
        // By using repositories.UserRepository.findUserByUsernameAndPassword()
        // Return controllers.enum.AuthenticationResult (EMPTY_FIELDS or SUCCESS)
        return null;
    }


    public boolean isUniqueUsername(String username) {
        try {
            return userRepository.findUserByUsername(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

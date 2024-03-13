package controllers;

import contracts.PlayerContract;
import models.User;

import java.io.FileWriter;
import java.io.IOException;

public class UserController implements PlayerContract {

    private static UserController instance;

    private UserController() {

    }

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController();
        }
        return instance;
    }

    public void signUpButtonClicked(String username, String password, String confirmedPassword) {
        if (password.equals(confirmedPassword)) {
            try {
                FileWriter writer = new FileWriter("player_credentials.txt", true);
                writer.write("Username: " + username + ", Password: " + password + "\n");
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public boolean isExistedPlayer(String username) {
        return false;
    }

    @Override
    public void registerPlayer(User user) {

    }

    @Override
    public boolean isValidLogin(String username, String password) {
        return false;
    }
}

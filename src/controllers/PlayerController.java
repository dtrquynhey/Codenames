package controllers;

import contracts.PlayerContract;
import models.Player;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class PlayerController implements PlayerContract {

    private static PlayerController instance;

    private PlayerController() {

    }

    public static PlayerController getInstance() {
        if (instance == null) {
            instance = new PlayerController();
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
    public void registerPlayer(Player player) {

    }

    @Override
    public boolean isValidLogin(String username, String password) {
        return false;
    }
}

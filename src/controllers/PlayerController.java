package controllers;

import contracts.IPlayerContract;
import controllers.enums.RoomCreationResult;
import models.Player;
import views.gui.TeamSetupPanel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerController implements IPlayerContract {

    private static PlayerController instance;
    private List<Player> players = new ArrayList<>();

    public PlayerController() {
    }


    public static PlayerController getInstance() {

        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public void setPlayers(String[] usernames) {
        for (String u : usernames) {
            this.players.add(new Player(u));
        }
    }

}

package controllers;

import contracts.IPlayerContract;
import controllers.enums.RoomCreationResult;
import models.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayerController implements IPlayerContract {

    private static PlayerController instance;

    public PlayerController() {
    }

    public static PlayerController getInstance() {

        if (instance == null) {
            instance = new PlayerController();
        }
        return instance;
    }

    @Override
    public List<Player> createRoom(String[] uniqueNicknames) {

        List<Player> playerList = new ArrayList<>();
        for (String nickname : uniqueNicknames) {
            Player player = new Player(nickname);
            playerList.add(player);
        }
        return playerList;
    }

    @Override
    public RoomCreationResult isValidNicknames(String[] playerNicknames) {
        Set<String> uniqueNicknames = new HashSet<>();
        for (String nickname : playerNicknames) {
            if (nickname == null || nickname.trim().isEmpty()) {
                return RoomCreationResult.MISSING_NAMES;
            }
            if (uniqueNicknames.contains(nickname)) {
                return RoomCreationResult.DUPLICATE_NAMES;
            }
            uniqueNicknames.add(nickname);
        }
        return RoomCreationResult.SUCCESS;
    }
}

package controllers;

import contracts.IPlayerContract;
import controllers.enums.RoomCreationResult;
import models.Player;
import repositories.PlayerRepository;
import repositories.UserRepository;
import repositories.mappers.PlayerMapper;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PlayerController implements IPlayerContract {

    private static PlayerController instance;
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public static PlayerController getInstance(PlayerRepository playerRepository) {

        if (instance == null) {
            instance = new PlayerController(playerRepository);
        }
        return instance;
    }

    @Override
    public RoomCreationResult createNewRoom(String[] playerNicknames) {
        Set<String> uniqueNicknames = new HashSet<>();
        for (String nickname : playerNicknames) {
            if (nickname == null || nickname.trim().isEmpty()) {
                return RoomCreationResult.MISSING_PLAYERS;
            }
            if (uniqueNicknames.contains(nickname)) {
                return RoomCreationResult.DUPLICATE_NAMES;
            }
            uniqueNicknames.add(nickname);
        }
        try {
            for (String playerNickname : playerNicknames) {
                Player player = new Player(playerNickname);
                playerRepository.createPlayer(player);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return RoomCreationResult.SUCCESS;
    }
}

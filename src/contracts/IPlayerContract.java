package contracts;

import controllers.enums.RoomCreationResult;
import models.Player;

import java.util.List;

public interface IPlayerContract {

    List<Player> createRoom(String[] uniqueNicknames);

    RoomCreationResult isValidNicknames(String[] playerNicknames);

}

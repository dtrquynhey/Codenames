package contracts;

import controllers.enums.RoomCreationResult;

public interface IPlayerContract {

    void createPlayers(String[] players);

    RoomCreationResult isValidPlayerNames(String[] playerNicknames);

}

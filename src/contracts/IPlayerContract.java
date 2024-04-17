package contracts;

import controllers.enums.RoomCreationResult;

public interface IPlayerContract {

    void setPlayers(String[] players);

    RoomCreationResult isValidPlayerNames(String[] playerNicknames);

}

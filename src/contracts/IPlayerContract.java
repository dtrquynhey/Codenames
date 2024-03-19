package contracts;

import controllers.enums.RoomCreationResult;

public interface IPlayerContract {

    RoomCreationResult createNewRoom(String[] playerNicknames);

}

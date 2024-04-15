package contracts;

import controllers.enums.RoomCreationResult;
import models.Account;

import java.util.List;

public interface IPlayerContract {

    void createRoom(List<Account> accounts);

    RoomCreationResult isValidPlayerNames(String[] playerNicknames);

}

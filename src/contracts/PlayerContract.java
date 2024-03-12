package contracts;

import models.Player;

public interface PlayerContract {

    boolean isExistedPlayer(String username);
    void registerPlayer(Player player);
    boolean isValidLogin(String username, String password);
}

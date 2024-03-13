package contracts;

import models.User;

public interface PlayerContract {

    boolean isExistedPlayer(String username);
    void registerPlayer(User user);
    boolean isValidLogin(String username, String password);
}

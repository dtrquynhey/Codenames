package contracts;

import controllers.AuthenticationResult;
import models.User;

public interface UserContract {
    AuthenticationResult registerUser(String username, String password, String confirmPassword);
    AuthenticationResult logUserIn(String username, String password);
}

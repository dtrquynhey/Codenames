package contracts;

import controllers.enums.AuthenticationResult;

public interface IAccountContract {
    boolean isUniqueUsername(String username);
    AuthenticationResult isValidSignupCredentials(String username, String password, String confirmPassword);
    void signPlayerUp(String username, String password);

    AuthenticationResult isValidLoginCredentials(String username, String password);
    void logPlayerIn(String username);
}

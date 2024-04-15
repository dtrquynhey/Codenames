package contracts;

import controllers.enums.AuthenticationResult;

public interface IAccountContract {
    AuthenticationResult isValidSignupCredentials(String username, String password, String confirmPassword);
    void signUp(String username, String password);

    AuthenticationResult isValidLoginCredentials(String username, String password);
    void logIn(String username);
    void logOut();
}

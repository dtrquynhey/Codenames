package contracts;

import controllers.enums.AuthenticationResult;

public interface IAccountContract {
    AuthenticationResult isValidSignUpCredentials(String username, String password, String confirmPassword);
    AuthenticationResult signUp(String username, String password);

    AuthenticationResult isValidLoginCredentials(String username, String password);
    AuthenticationResult logIn(String username);
    void logOut();
}

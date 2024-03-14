package contracts;

import controllers.enums.AuthenticationResult;

public interface UserContract {
    AuthenticationResult registerUser(String username, String password, String confirmPassword);

    // TODO: (DONE) Second. Create a contract between User and System (User asks to log in)
    AuthenticationResult logUserIn(String username, String password);
}

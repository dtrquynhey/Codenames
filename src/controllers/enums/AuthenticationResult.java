package controllers.enums;

public enum AuthenticationResult {
    EMPTY_FIELDS, // fields are empty
    EXISTING_USER, // in SignUp (duplicated username)
    PASSWORD_MISMATCH, // in SignUp (password and confirmPassword aren't matched)
    INVALID_CREDENTIALS, // in LogIn (either username doesn't exist or password isn't correct)
    SUCCESS, // in SignUp and LogIn (success)
}

package controllers.enums;

public enum AuthenticationResult {
    EMPTY_FIELDS,
    EXISTING_USER,
    PASSWORD_MISMATCH,

    VALID,
    INVALID_CREDENTIALS,
    SUCCESS,
}

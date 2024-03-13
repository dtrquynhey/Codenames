package controllers;

public enum AuthenticationResult {
    SUCCESS,
    EMPTY_FIELDS,
    EXISTING_USER,
    PASSWORD_MISMATCH,
}

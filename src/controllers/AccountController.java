package controllers;

import contracts.IAccountContract;
import controllers.enums.AuthenticationResult;
import models.Account;
import models.Player;
import repositories.AccountRepository;

import java.sql.SQLException;

public class AccountController implements IAccountContract {

    private static AccountController instance;
    private final AccountRepository accountRepository;
    private Player loggedInPlayers;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public static AccountController getInstance(AccountRepository accountRepository) {

        if (instance == null) {
            instance = new AccountController(accountRepository);
        }
        return instance;
    }

    @Override
    public AuthenticationResult isValidSignupCredentials(String username, String password, String confirmedPassword) {

        if (username.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) {
            return AuthenticationResult.EMPTY_FIELDS;

        } else if (isUniqueUsername(username)) {
            return AuthenticationResult.EXISTING_USER;

        } else if (!password.equals(confirmedPassword)) {
            return AuthenticationResult.PASSWORD_MISMATCH;
        }
        return AuthenticationResult.SUCCESS;
    }

    @Override
    public void signPlayerUp(String username, String password) {
        try {
            Account newAccount = new Account(username, password);
            accountRepository.insertAccount(newAccount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
            // TODO: catch SQLException
        }
    }


    @Override
    public AuthenticationResult isValidLoginCredentials(String username, String password) {
        if (username.isEmpty() || password.isEmpty()){
            return AuthenticationResult.EMPTY_FIELDS;
        }
        try {
            if (!accountRepository.findAccount(username, password)) {
                return AuthenticationResult.INVALID_CREDENTIALS;
            }
            else return AuthenticationResult.SUCCESS;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void logPlayerIn(String username) {
        loggedInPlayers = new Player(username);
    }


    @Override
    public boolean isUniqueUsername(String username) {
        try {
            return accountRepository.findAccount(username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
            // TODO: catch SQLException
        }
    }
}

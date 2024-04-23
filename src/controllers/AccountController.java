package controllers;

import contracts.IAccountContract;
import controllers.enums.AuthenticationResult;
import controllers.enums.RoomCreationResult;
import models.Account;
import repositories.AccountRepository;
import views.gui.RoomCreationPanel;

import java.util.ArrayList;
import java.util.List;

public class AccountController implements IAccountContract {

    private static AccountController instance;
    private final AccountRepository accountRepository = new AccountRepository();

    private Account account;
    public int accountIndex;
    public Account getAccount() {
        return account;
    }


    private final List<Account> accounts = new ArrayList<>();
    public List<Account> getAccounts() {
        return accounts;
    }


    public RoomCreationResult addAccount(String username) {
        Account account = new Account(username);
        for (Account a: accounts) {
            if (a.getUsername().equals(account.getUsername())) {
                return RoomCreationResult.DUPLICATE_NAMES;
            }
        }
        accounts.add(accountIndex, account);
        return RoomCreationResult.SUCCESS;
    }

    public void removeAccount(String username) {
        Account account = new Account(username);
        for (Account a: accounts) {
            if (a.getUsername().equals(account.getUsername())) {
                a.setUsername("");
            }
        }
    }

    public void setFirstAccount(String username) {

        if (accounts.isEmpty()) {
            accounts.add(new Account(username));
        } else {
            accounts.getFirst().setUsername(username);
        }
    }
    public AccountController() {
    }

    public static AccountController getInstance() {

        if (instance == null) {
            instance = new AccountController();
        }
        return instance;
    }

    @Override
    public AuthenticationResult isValidSignUpCredentials(String username, String password, String confirmedPassword) {

        if (username.isEmpty() || password.isEmpty() || confirmedPassword.isEmpty()) {
            return AuthenticationResult.EMPTY_FIELDS;

        } else if (accountRepository.findAccount(username)) {
            return AuthenticationResult.EXISTING_USER;

        } else if (!password.equals(confirmedPassword)) {
            return AuthenticationResult.PASSWORD_MISMATCH;
        }
        return AuthenticationResult.SUCCESS;
    }

    @Override
    public AuthenticationResult signUp(String username, String password) {
        if (accountRepository.findAccount(username)) {
            return AuthenticationResult.EXISTING_USER;
        }
        Account newAccount = new Account(username, password);
        accountRepository.insertAccount(newAccount);
        return AuthenticationResult.SUCCESS;
    }

    public void deleteAccount(String username) {
        accountRepository.deleteAccount(username);
    }

    @Override
    public AuthenticationResult isValidLoginCredentials(String username, String password) {
        if (username.isEmpty() || password.isEmpty()){
            return AuthenticationResult.EMPTY_FIELDS;
        }
        if (!accountRepository.findAccount(username, password)) {
            return AuthenticationResult.INVALID_CREDENTIALS;
        }
        else return AuthenticationResult.SUCCESS;
        }

    @Override
    public AuthenticationResult logIn(String username, String password) {
        if (accountRepository.findAccount(username, password)) {
            account = new Account(username);
            return AuthenticationResult.SUCCESS;
        } else {
           return AuthenticationResult.INVALID_CREDENTIALS;
        }
    }

    public void logOut() {
        account = null;
    }



}

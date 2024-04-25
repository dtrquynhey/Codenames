package controllers;

import controllers.enums.AuthenticationResult;
import controllers.enums.RoomCreationResult;
import models.Account;
import repositories.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountController {

    private static AccountController instance;
    private final AccountRepository accountRepository = new AccountRepository();

    private Account account;
    public int accountIndex;
    public Account getAccount() {
        return account;
    }


    private List<Account> accounts;
    public List<Account> getAccounts() {
        return accounts;
    }
    public void initializeAccounts() {
        accounts = new ArrayList<>();
    }

    public RoomCreationResult addAccount(String username) {
        Account account = new Account(username);
        for (Account a: accounts) {
            if (a.getUsername().equals(account.getUsername())) {
                return RoomCreationResult.DUPLICATE_NAMES;
            }
        }
        accounts.add(account);
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

    public AuthenticationResult signUp(String username, String password) {
        if (accountRepository.findAccount(username)) {
            return AuthenticationResult.EXISTING_USER;
        }
        Account newAccount = new Account(username, password);
        accountRepository.insertAccount(newAccount);
        return AuthenticationResult.SUCCESS;
    }

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

    public void deleteAccount(String username) {
        accountRepository.deleteAccount(username);
    }

}

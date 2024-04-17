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
    private final AccountRepository accountRepository;
    private Account mainAccount;
    public int accountIndex;


    private List<Account> accounts = new ArrayList<>();
    public List<Account> getAccounts() {
        return accounts;
    }
    public Account getMainAccount() {
        return mainAccount;
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
    public void signUp(String username, String password) {
        Account newAccount = new Account(username, password);
        accountRepository.insertAccount(newAccount);
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
    public void logIn(String username) {
        mainAccount = new Account(username);
    }

    public void logOut() {
        accounts = null;
    }


//    public RoomCreationPanel initializeRoomCreationPanel() {
//        return new RoomCreationPanel(getInstance(accountRepository));
//    }

    public void setFirstAccount(String username) {

        if (accounts.isEmpty()) {
            accounts.add(new Account(username));
        } else {
            accounts.getFirst().setUsername(username);
        }
    }

}

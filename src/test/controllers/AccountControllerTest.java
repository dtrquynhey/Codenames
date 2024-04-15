package controllers;

import controllers.enums.AuthenticationResult;
import models.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import repositories.AccountRepository;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AccountControllerTest {

    private AccountRepository accountRepository;
    private AccountController accountController;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);
        accountController = new AccountController(accountRepository);
    }

    @Test
    void testRegisterUser_emptyFields() {
        // Test with empty fields
        assertEquals(AuthenticationResult.EMPTY_FIELDS, accountController.isValidSignupCredentials("", "", ""));
        // Verify that createUser method is not called
        verifyNoInteractions(accountRepository);
    }

    @Test
    void testRegisterUser_passwordMismatch() {
        // Test with password mismatch
        assertEquals(AuthenticationResult.PASSWORD_MISMATCH, accountController.isValidSignupCredentials("username", "password1", "password2"));
        // Verify that createUser method is not called
        verifyNoInteractions(accountRepository);
    }
}
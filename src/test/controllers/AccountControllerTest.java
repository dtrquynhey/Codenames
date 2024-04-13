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

    @Test
    void testRegisterUser_successfulRegistration() {
        // Test successful registration
        assertEquals(AuthenticationResult.SUCCESS, accountController.isValidSignupCredentials("username", "password", "password"));
        // Verify that createUser method is called with the correct User object
        try {
            ArgumentCaptor<Account> userCaptor = ArgumentCaptor.forClass(Account.class);
            // Verify that createUser method is called with the correct User object
            verify(accountRepository).insertAccount(userCaptor.capture());
            // Retrieve the captured User object
            Account capturedAccount = userCaptor.getValue();
            // Assert that the captured User object has the expected content
            assertEquals("username", capturedAccount.getUsername());
            assertEquals("password", capturedAccount.getPassword());
        } catch (SQLException e) {
            System.out.println("Error while creating new user!");
        }
    }
}
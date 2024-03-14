package controllers;

import controllers.enums.AuthenticationResult;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import repositories.UserRepository;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class UserControllerTest {

    private UserRepository userRepository;
    private UserController userController;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userController = new UserController(userRepository);
    }

    @Test
    void testRegisterUser_emptyFields() {
        // Test with empty fields
        assertEquals(AuthenticationResult.EMPTY_FIELDS, userController.registerUser("", "", ""));
        // Verify that createUser method is not called
        verifyNoInteractions(userRepository);
    }

    @Test
    void testRegisterUser_passwordMismatch() {
        // Test with password mismatch
        assertEquals(AuthenticationResult.PASSWORD_MISMATCH, userController.registerUser("username", "password1", "password2"));
        // Verify that createUser method is not called
        verifyNoInteractions(userRepository);
    }

    @Test
    void testRegisterUser_successfulRegistration() {
        // Test successful registration
        assertEquals(AuthenticationResult.SUCCESS, userController.registerUser("username", "password", "password"));
        // Verify that createUser method is called with the correct User object
        try {
            ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
            // Verify that createUser method is called with the correct User object
            verify(userRepository).createUser(userCaptor.capture());
            // Retrieve the captured User object
            User capturedUser = userCaptor.getValue();
            // Assert that the captured User object has the expected content
            assertEquals("username", capturedUser.getUsername());
            assertEquals("password", capturedUser.getPassword());
        } catch (SQLException e) {
            System.out.println("Error while creating new user!");
        }
    }
}
package controllers;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {

    @Test
    void signUpButtonClicked_withMatchPasswords_writeToFile() {
        UserController userController = UserController.getInstance();
        String username = "quynh";
        String password = "123";
        String confirmedPassword = "111";
        String expectedContent = "Username: quynh, Password: 123";

        userController.signUpButtonClicked(username, password, confirmedPassword);

        try (BufferedReader reader = new BufferedReader(new FileReader("user_credentials.txt"))) {
            String line;
            StringBuilder actualContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                actualContent.append(line.trim());
            }
            assertEquals(expectedContent, actualContent.toString());

        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException occurred while reading file");
        }
    }

}
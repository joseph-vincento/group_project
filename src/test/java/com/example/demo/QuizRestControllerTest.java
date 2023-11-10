package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class QuizRestControllerTest {

    private QuizRestController controller = new QuizRestController();

    @Test
    public void testEmailCheckValid() {
        EmailStatus result = controller.emailCheck("test@example.com");
        assertTrue(result.valid());
    }

    @Test
    public void testEmailCheckInvalid() {
        EmailStatus result = controller.emailCheck("testexample.com");
        assertFalse(result.valid());
    }

    @Test
    public void testPasswordCheckValid() {
        PasswordStatus result = controller.passwordCheck("password123");
        assertTrue(result.isValidPassword());
    }

    @Test
    public void testPasswordCheckInvalid() {
        PasswordStatus result = controller.passwordCheck("pass");
        assertFalse(result.isValidPassword());
    }

    @Test
    public void testGetQuestion() {
        Question result = controller.getQuestion();
        assertNotNull(result);
    }
}
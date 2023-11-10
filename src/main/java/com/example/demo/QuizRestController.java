package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class QuizRestController {
    private static int questionCounter = 0;

    @PostMapping("/email_check")
    @ResponseStatus(HttpStatus.OK)
    public EmailStatus emailCheck(@RequestParam(value="email", defaultValue="none") String email) {
        boolean isValidEmail = email.contains("@");
        return new EmailStatus(email, isValidEmail);
    }

    @PostMapping("/password_check")
    @ResponseStatus(HttpStatus.OK)
    public PasswordStatus passwordCheck(@RequestParam(value="password", defaultValue="none") String password) {
        int length = password.length();
        boolean isValidPassword = (length >= 8);
        return new PasswordStatus(password, length, isValidPassword);
    }

    @GetMapping("/get_question")
    @ResponseStatus(HttpStatus.OK)
    public Question getQuestion() {
        return new QuestionList().getQuestion();
    }
}
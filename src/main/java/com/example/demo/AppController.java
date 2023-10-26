package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/welcome_page", "/"})
    public String welcomePage() {
        return "welcome_page";
    }

    // Endpoint for the login (or quiz home) page
    @GetMapping("/quiz_home")
    public String quizHome() {
        return "quiz_home"; // This should match the name of your quiz_home.html
    }

    // Endpoint for the sign-up page
    @GetMapping("/signUp")
    public String signUp() {
        return "signUp"; // This should match the name of your signUp.html
    }

}

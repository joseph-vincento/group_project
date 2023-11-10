package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@Controller
public class QuizViewController {

    @GetMapping("/")
    public String welcomepageForm(Model model) {
        System.out.println("hitting /...");
        model.addAttribute("loginCreds", new LoginCreds());
        model.addAttribute("questions", new QuestionList());
        return "welcomepage";
    }

    @PostMapping("/login")
    public String loginSubmit(@ModelAttribute LoginCreds loginCreds, @ModelAttribute QuestionList questions, Model model) {
        System.out.println("hitting /login...");
        model.addAttribute("loginCreds", loginCreds);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String email = loginCreds.getEmail();
        String password = loginCreds.getPassword();

        HttpEntity<String> entity = new HttpEntity<>("{\"pwd\":\"yipes\"}", headers);
        ResponseEntity<String> response_email = restTemplate.postForEntity(
                "http://localhost:8092/email_check?email=" + email, 
                entity, 
                String.class
            );
        System.out.println(response_email.getBody().toString());

        ResponseEntity<String> response_password = restTemplate.postForEntity(
                "http://localhost:8092/password_check?password=" + password, 
                entity, 
                String.class
            );
        System.out.println(response_password.getBody().toString());

        // Needs functionality to return an error page is either check fails
        return "loginpage";
    }
    
    @PostMapping("/question")
    public String questionForm(@ModelAttribute QuestionList questions, Model model) {
        System.out.println("hitting /question...");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>("{\"pwd\":\"yipes\"}", headers);
        ResponseEntity<String> question_response = restTemplate.getForEntity(
            "http://localhost:8092/get_question",
            String.class
        );
        System.out.println(question_response.getBody().toString());  

        // Parse the json string coming from the rest controller into key value pairs
        String jsonString = question_response.getBody().toString();
        jsonString = jsonString.replaceAll("[{}\"]", "");
        String[] keyValuePairs = jsonString.split(",");
        String question = "test";
        boolean correct = false;
        for(String pair : keyValuePairs) {
            String[] keyValue = pair.split(":");
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();
            System.out.println(key);
            System.out.println(value);
            if ("question".equals(key)) {
                question = value;
            } else if ("correct".equals(key)) {
                correct = Boolean.parseBoolean(value);
            }
        }      

        model.addAttribute("qstn", new Question(question, correct));
        return "questionpage";
    } 
}
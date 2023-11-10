package com.example.demo;

public class Question {
    private String question;
    private boolean isCorrect;
    
    public Question(String question, boolean correct) {
        this.question = question;
        this.isCorrect = correct;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrect(boolean correct) {
        this.isCorrect = correct;
    }

    public String getQuestion() {
        return this.question;
    }

    public boolean getCorrect() {
        return this.isCorrect;
    }
}
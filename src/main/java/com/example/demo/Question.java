package com.example.demo;
import java.util.UUID;
import java.util.List;
public class Question {
    public UUID uuid;
    public String question;
    public boolean isCorrect;

    public Question(String question, boolean isCorrect) {
        this.question = question;
        this.isCorrect = isCorrect;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    };
}

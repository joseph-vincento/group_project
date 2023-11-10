package com.example.demo;

import java.util.ArrayList;

public class QuestionList {
    private static ArrayList<Question> list = new ArrayList();
    private static int i = 0;

    public QuestionList() {
        list.add(new Question("The square root of 2 is rational.", false));
        list.add(new Question("An octagon has 8 sides", true));
        list.add(new Question("Earth is approximately 4.5 billion years old", true));
    }

    public Question getQuestion() {
        if(i >= list.size()) {
            i = 0;
        }
        Question q = list.get(i);
        i++;
        return q;
    }
}
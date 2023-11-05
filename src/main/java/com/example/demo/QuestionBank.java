package com.example.demo;
import java.util.UUID;
import java.util.List;
import java.util.ArrayList;
public class QuestionBank {

    public static List<Question> questionList = new ArrayList();

    public QuestionBank() {
        questionList.add(new Question("3 X 3 = 7", false));
        questionList.add(new Question("Geroge Washington was our first president", true));
        questionList.add(new Question("20 +20 = 30", false));
    }
        
    

    public static Question getQuestion(int i) {
        return questionList.get(i);
    }
}

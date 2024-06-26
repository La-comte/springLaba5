package ru.bmstu.game;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bmstu.question.Question;

import java.util.ArrayList;
import java.util.Scanner;

import static ru.bmstu.colors.Colors.*;

@Getter
@Setter
@ToString
@Service
public class Game {
    @Autowired
    ArrayList<Question> questions;
    private Integer cnt = 0;

    public void quiz(){
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_CYAN + "Welcome to Fyodor Dostoyevsky Quiz" + ANSI_RESET);
        for (int i = 0; i < questions.size(); i++){
            System.out.println(ANSI_PURPLE_BOLD + questions.get(i).getQuestion()+ ANSI_RESET);
            for (int j = 0; j < questions.size(); j++){
                System.out.println(questions.get(i).getAnswers().get(j));
            }
            String youAnswer = in.nextLine();
            if (youAnswer.equals(questions.get(i).getAnswer())){
                setCnt(getCnt()+1);
                System.out.println(ANSI_GREEN_BOLD + "True\n" + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED_BOLD + "False\n" + ANSI_RESET);
            }
        }
        result();
    }
    private void result(){
        if (getCnt() < (questions.size()/2)){
            System.out.println(ANSI_RED_BOLD + "You result:\t" + (getCnt()*100)/questions.size() + "%" + ANSI_RESET);
        } else{
            System.out.println(ANSI_GREEN_BOLD + "Perfectly! You result:\t" + (getCnt()*100)/questions.size() + "%" + ANSI_RESET);
        }
    }
}

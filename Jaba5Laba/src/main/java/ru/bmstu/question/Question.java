package ru.bmstu.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Question {
    private String question;
    private ArrayList<String> answers;
    private String answer;
}

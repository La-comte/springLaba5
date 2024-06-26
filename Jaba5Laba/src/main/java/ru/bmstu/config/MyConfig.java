package ru.bmstu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ru.bmstu.question.Question;
import ru.bmstu.question.ReadQuestions;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:settings.properties")
@ComponentScan("ru.bmstu")
public class MyConfig {
    @Autowired
    Environment env;
    @Bean
    public ArrayList<Question> getQuestions() {
        ReadQuestions readQuestions = new ReadQuestions();
        readQuestions.setFilename(env.getProperty("DostoevskyQuiz"));
        ArrayList<Question> questions = readQuestions.read();
        return questions;
    }
}

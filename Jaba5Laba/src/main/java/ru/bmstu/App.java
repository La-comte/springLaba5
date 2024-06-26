package ru.bmstu;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bmstu.config.MyConfig;
import ru.bmstu.game.Game;


public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        Game game = context.getBean("game", Game.class);
        System.out.println(game);
        game.quiz();

        context.close();
//            System.out.printf("Question: %s%n\t1. %s%n\t2. %s%n\t3. %s%n\t4. %s%nAnswer: %s%n%n", question, ans1, ans2, ans3, ans4, answer);
    }
}


package ru.bmstu.question;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.CSVReaderHeaderAwareBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import ru.bmstu.App;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

@Component
@Getter
@Setter
@ToString
public class ReadQuestions {
    private String filename;

    public ArrayList<Question> read() {
        InputStream inputStream = App.class.getResourceAsStream("/" + filename);
        InputStreamReader inputStreamReader = new InputStreamReader(Objects.requireNonNull(inputStream));
        CSVReaderHeaderAware csvReader = new CSVReaderHeaderAwareBuilder(inputStreamReader).withCSVParser(new CSVParserBuilder().withSeparator(';').build()).build();

        ArrayList<Question> questions = new ArrayList<>();

        Map<String, String> map;
        for (int i = 0; i < csvReader.getLinesRead(); i++) {
            try {
                map = csvReader.readMap();
                if (map == null)
                    continue;
            } catch (IOException | CsvValidationException e) {
                throw new RuntimeException(e);
            }
            String question = map.get("Question");
            String ans1 = map.get("1");
            String ans2 = map.get("2");
            String ans3 = map.get("3");
            String ans4 = map.get("4");
            String answer = map.get("Answer");
            questions.add(new Question(question, new ArrayList<>() {{
                add(ans1);
                add(ans2);
                add(ans3);
                add(ans4);
            }}, answer));
        }
        return questions;
    }
}
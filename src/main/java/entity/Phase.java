package entity;

import lombok.Data;

import java.util.List;
@Data
public class Phase {
    String text;
    List<Answer> answers;

    public Phase(String text, List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }
}

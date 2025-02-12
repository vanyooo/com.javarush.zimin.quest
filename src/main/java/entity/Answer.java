package entity;

import lombok.Data;

@Data
public class Answer {

    long id;
    String text;

    public Answer(long id, String text) {
        this.id = id;
        this.text = text;
    }
}


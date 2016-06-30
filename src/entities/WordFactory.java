package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HomePC1 on 30.06.2016.
 */
public class WordFactory {
    private static final Map<String, Word> entireWords = new HashMap<>();

    public Word getWord(String value) {
        Word word = entireWords.get(value);

        if (word == null) {
            word = new Word(value);
            entireWords.put(value, word);
        }

        return word;
    }
}


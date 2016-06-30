package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * A subsidiary class to keep word.
 * Helps using flyweight pattern
 */
public class WordFactory {
    /**
     * entireWords - map of word object and their values
     */
    private static final Map<String, Word> entireWords = new HashMap<>();

    /**
     * A method to check if a word already exists
     * Get a word from a map by its value
     * If an object is null - create new word with specified value
     * @param value is word's value
     * @return required word by its value
     */
    public Word getWord(String value) {
        Word word = entireWords.get(value);

        if (word == null) {
            word = new Word(value);
            entireWords.put(value, word);
        }

        return word;
    }
}


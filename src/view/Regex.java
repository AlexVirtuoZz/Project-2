package view;

/**
 * Created by HomePC1 on 29.06.2016.
 */
public interface Regex {
    String SENTENCE_DELIMETERS = "[.!?]+";
    String WORDS_DELIMETERS = "[,;:/ ()\n]+";
    String CODE_DELIMETERS = "-code-.*?-code-";
}

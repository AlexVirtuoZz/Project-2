package entities;

import java.util.LinkedList;
import java.util.List;

/**
 * A class representing Sentence
 */
public class Sentence implements Text {
    /**
     * words - list of words, included in a sentence
     */
    private List<Word> words = new LinkedList();

    /**
     * Sentence object constructor
     * @param words list of words
     */
    public Sentence(List<Word> words) {
        this.words = words;
    }

    //Getters and setters

    public List<Word> getWords() {
        return words;
    }
    //Overridden methods
    /**
     * A method to represent sentence as a String object
     * Represent sentence as word values, included in word list
     * @return sentence text representation
     */
    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for (Word word : words){
            stringBuffer.append(word).append(" ");
        }
        return stringBuffer.toString();
    }
}

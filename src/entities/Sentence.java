package entities;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by HomePC1 on 29.06.2016.
 */
public class Sentence {
    private List<Word> words = new LinkedList();

    public Sentence(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }

    @Override
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for (Word word : words){
            stringBuffer.append(word).append(" ");
        }
        return stringBuffer.toString();
    }
}

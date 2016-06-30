package controller;

import entities.Sentence;
import entities.Word;
import view.View;

import java.io.*;

/**
 * Created by HomePC1 on 29.06.2016.
 */
public class Controller {
    Parser parser = new Parser();
    View view = new View();

    public void process()  {
        try {
            parser.readProperties();
            view.print(view.ENTIRE_TEXT);
            parser.parseText();
            view.print(parser.getText());
            parser.parseSentences();
            view.print(view.ENTIRE_WORDS);
            parser.parseWords();
            for (Word word : parser.getWords())
                view.print(word.toString());
        } catch (IOException e){
            view.print(view.IOEXCEPTION);
        }
        view.print(view.PARSING_WORDS);
        for (Word word : parser.getWords()){
            countWord(word);
        }

        parser.sortWords();
        view.print(view.SORTED_WORDS);
        for (Word w : parser.getWords())
            view.print(w.toString());
    }

    //Utility methods
    private void countWord(Word word){
        int sentenceCounter = 0;
        for (Sentence sentence : parser.getSentences()){
            sentenceCounter++;
            for (Word localWord : sentence.getWords()){
                if (localWord.equals(word)){
                    word.increase();
                }
            }
            view.printWithCount(word.toString(), word.getCounter(), sentenceCounter);
        }
        view.printWithEntireCount(word.toString(), word.getCounter());
    }
}

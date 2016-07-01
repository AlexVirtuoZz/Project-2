package controller;

import entities.CounterWordDecorator;
import entities.Sentence;
import entities.Word;
import view.View;

import java.io.*;

/**
 * A class to process entire program
 */
public class Controller {
    /**
     * parser - object to parse text
     * view - object to print messages
     */
    private Parser parser;
    private View view;

    /**
     * Controller constructor
     * @param parser its parser object
     * @param view its view object
     */
    public Controller(Parser parser, View view) {
        this.parser = parser;
        this.view = view;
    }

    /**
     * Main method to process entire program
     * read properties to get text and words files
     * print welcome message
     * parse text from file
     * print entire text
     * divide text into sentences
     * parse words from file
     * print entire word list
     * obtain word \ sentence and word \ text info
     * @see #countWord(CounterWordDecorator)
     * sort words and print sorted list of words
     * @exception IOException - if occur - display appropriate message and exit program
     */
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
            System.exit(0);
        }
        view.print(view.PARSING_WORDS);
        parser.decorateWordsByCounter();
        for (CounterWordDecorator word : parser.getDecoratedWordsByCounter())
            countWord(word);
        parser.sortDecoratedWords();
        for (Word word : parser.getDecoratedWordsByCounter())
            view.print(word.toString());
    }

    //Utility methods

    /**
     * A method to get word \ sentence and word \ text info
     * for each sentence - search if specified word and any word in sentence are equals
     * if such words found - increase counter of specified word
     * for each iteration of sentence set word sentence counter to zero
     * print, how many specified words were found in every sentence
     * print, how many specified words were found in entire text
     * @param word specified word
     */
    private void countWord(CounterWordDecorator word){
        int sentenceCounter = 0;
        for (Sentence sentence : parser.getSentences()){
            sentenceCounter++;
            for (Word localWord : sentence.getWords()){
                if (localWord.equals(word)){
                    word.increase();
                }
            }
            view.printWithCount(word.toString(), word.getSentenceCounter(), sentenceCounter);
            word.newSentence();
        }
        view.printWithEntireCount(word.toString(), word.getEntireCounter());
    }
}

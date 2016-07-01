package controller;

import entities.CounterWordDecorator;
import entities.Sentence;
import entities.Word;
import entities.WordFactory;
import view.Regex;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class to parse text
 */
public class Parser {
    /**
     * sentences - list of sentences from text
     * words - list of words to parse text
     * wordFactory - an object to keep words
     * textProperty - property to get entire text file
     * wordProperties - property to get entire word list
     * text - entire text to parse
     */
    private List<Sentence> sentences = new LinkedList<>();
    private Set<Word> words = new HashSet<>();
    private LinkedList decoratedWordsByCounter;
    private WordFactory wordFactory = new WordFactory();
    private String textProperty;
    private String wordProperties;
    private String text;

    //Getters and setters
    public List<CounterWordDecorator> getDecoratedWordsByCounter() {
        return decoratedWordsByCounter;
    }

    public Set<Word> getWords() {
        return words;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public String getText() {
        return text;
    }

    /**
     * A method to split text by required regex
     * While text matches regex - divide text into list of strings
     * @param text text to parse
     * @param regex condition to parse text
     * @return divided text into string array
     */
    public List<String> split(String text, String regex){
        List<String> temp = new LinkedList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int start = 0;
        int finish;

        while(matcher.find()){
            finish = matcher.start();
            temp.add(text.substring(start, finish).trim());
            start = matcher.end();
        }

        if(start<text.length()-1){
            temp.add(text.substring(start, text.length()).trim());
        }
        return temp;
    }

    /**
     * A method to get text file to read from
     * @throws IOException if problems occur while reading
     */
    public void readProperties() throws IOException {
        File file = new File("file.properties");
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        textProperty = properties.getProperty("input_text");
        wordProperties = properties.getProperty("input_words");
        fileInputStream.close();
    }

    /**
     * A method to read text from file
     * Create and try to initialize required readers
     * While there are lines to read - append it to stringBuffer
     * @param from file path to read from
     * @return entire text from file
     * @throws IOException if problems occur while reading from file
     */
    public String readFromFile(String from) throws IOException {
        FileReader fr = null;
        BufferedReader br = null;
        StringBuffer fileValue = new StringBuffer();
        try {
            fr = new FileReader(from);
            br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                fileValue.append(line);
                fileValue.append(" ");
            }
        }finally {
            if (fr != null) {
                fr.close();
            }
            if (br != null) {
                br.close();
            }
        }

        return fileValue.toString();
    }

    /**
     * A method to clean entire text from code
     * @param text - entire text
     * @return text without code
     */
    public String cleanText(String text){
        return text.replaceAll(Regex.CODE_DELIMETERS, "");
    }

    /**
     * A method to read entire text from file
     * @throws IOException if problems occur while reading from file
     */
    public void parseText() throws IOException{
        text = readFromFile(textProperty);
    }

    /**
     * A method to divide entire text into sentences
     * Split entire text into String array (temporary sentences)
     * For each string - divide it into words and add to sentences list
     */
    public void parseSentences() {
        List<String> temp = split(cleanText(text), Regex.SENTENCE_DELIMETERS);
        for (String sent: temp){
            List<Word> local = new LinkedList<>();
            for (String word : sent.split(Regex.WORDS_DELIMETERS))
                local.add(wordFactory.getWord(word));
            sentences.add(new Sentence(local));
        }
    }

    /**
     * A method to read word list from file
     * Read word list into array of strings
     * Convert each into word
     * @throws IOException if problems occur while reading from file
     */
    public void parseWords() throws IOException {
        List<String> temp = split(readFromFile(wordProperties), Regex.WORDS_DELIMETERS);
        for (String word : temp){
            words.add(wordFactory.getWord(word));
        }
    }

    /**
     * A method to sort words
     * Convert set into array list
     * Use standard Collections.sort() method
     * @return linked hash set to keep words sorted
     */
    public void sortDecoratedWords(){
        Collections.sort(decoratedWordsByCounter);
    }

    /**
     * A method to decorate list of standard words into decorated words
     */
    void decorateWordsByCounter(){
        decoratedWordsByCounter = new LinkedList<>();
        for (Word word : words){
            decoratedWordsByCounter.add(word.decorateByCount());
        }
    }
}

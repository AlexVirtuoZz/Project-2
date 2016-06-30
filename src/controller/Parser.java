package controller;

import entities.Sentence;
import entities.Word;
import entities.WordFactory;
import view.Regex;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by HomePC1 on 29.06.2016.
 */
public class Parser {

    private List<Sentence> sentences = new LinkedList<>();
    private Set<Word> words = new HashSet<>();
    private WordFactory wordFactory = new WordFactory();
    private String textProperty;
    private String wordProperties;
    private String text;

    public Set<Word> getWords() {
        return words;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public String getText() {
        return text;
    }

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

    public void readProperties() throws IOException {
        File file = new File("file.properties");
        FileInputStream fileInput = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInput);
        textProperty = properties.getProperty("input_text");
        wordProperties = properties.getProperty("input_words");
        fileInput.close();
    }

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

    public String cleanText(String text){
        return text.replaceAll(Regex.CODE_DELIMETERS, "");
    }

    public void parseText() throws IOException{
        text = readFromFile(textProperty);
    }

    public void parseSentences() throws IOException {
        List<String> temp = split(cleanText(text), Regex.SENTENCE_DELIMETERS);
        for (String sent: temp){
            List<Word> local = new LinkedList<>();
            for (String word : sent.split(Regex.WORDS_DELIMETERS))
                local.add(wordFactory.getWord(word));
            sentences.add(new Sentence(local));
        }
    }

    public void parseWords() throws IOException {
        List<String> temp = split(readFromFile(wordProperties), Regex.WORDS_DELIMETERS);
        for (String word : temp){
            words.add(wordFactory.getWord(word));
        }
    }

    void sortWords(){
        ArrayList<Word> tmp = new ArrayList<>(words);
        Collections.sort(tmp);
        words = new LinkedHashSet<>(tmp);
    }
}

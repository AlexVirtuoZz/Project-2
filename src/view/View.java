package view;

/**
 * Created by HomePC1 on 29.06.2016.
 */
public class View {
    // System constants
    public static final String ENTIRE_TEXT = "Welcome to my parser.\nEntire text without code is\n";
    public static final String ENTIRE_WORDS = "Entire word list is\n";
    public static final String SORTED_WORDS = "Sorted word list:\n";
    public static final String PARSING_WORDS = "Parsing words in text...\n";
    // Exceptions
    public static final String IOEXCEPTION = "Input \\ output exception occur while processing!";

    public void print(String value){
        System.out.println(value);
    }

    public void printWithCount(String word, int count, int sentence){
        print ("Word \""+ word +"\" met "+ count +" times in "+ sentence +" sentence");
    }

    public void printWithEntireCount(String word, int count){
        print ("Word \""+ word +"\" met "+ count +" times in the entire text");
    }
}

package view;

/**
 * Class to work with text messages
 */
public class View {
    // System constants
    /**
     * All String constants required in program
     */
    public static final String ENTIRE_TEXT = "Welcome to my parser.\nEntire text is\n";
    public static final String ENTIRE_WORDS = "\nEntire word list is\n";
    public static final String SORTED_WORDS = "\nSorted word list:\n";
    public static final String PARSING_WORDS = "\nParsing words in text...\n";
    // Exceptions
    public static final String IOEXCEPTION = "\nInput \\ output exception occur while processing!";

    /**
     * A method to print messages
     * @param value message value
     */
    public void print(String value){
        System.out.println(value);
    }

    /**
     * A method to print word \ sentence info
     * @param word specified word
     * @param count count of specified words in a sentence
     * @param sentence nubmer of sentence in text
     */
    public void printWithCount(String word, int count, int sentence){
        print ("Word \""+ word +"\" met "+ count +" times in "+ sentence +" sentence");
    }

    /**
     * A method to print word \ text info
     * @param word specified word
     * @param count count of specified words in a text
     */
    public void printWithEntireCount(String word, int count){
        print ("Word \""+ word +"\" met "+ count +" times in the entire text");
    }

}

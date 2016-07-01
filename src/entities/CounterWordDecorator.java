package entities;

/**
 * A class to improve standard Word class by opportunity to be counted by occurrences
 */
public class CounterWordDecorator extends Word implements Comparable {
    /**
     * entireCounter - number of occurrences in text
     * sentenceCounter - number of occurrences in sentence
     */
    private int entireCounter;
    private int sentenceCounter;

    /**
     * Constructor with value
     * @param value word's text value
     */
    public CounterWordDecorator(String value) {
        super(value);
    }

    //Getters and setters

    public int getEntireCounter() {
        return entireCounter;
    }

    public int getSentenceCounter() {
        return sentenceCounter;
    }

    //Utility methods

    /**
     * A method to increase word's counters
     */
    public void increase(){
        entireCounter++;
        sentenceCounter++;
    }

    /**
     * A method to set sentence counter to zero
     */
    public void newSentence(){
        sentenceCounter = 0;
    }

    //Overridden method
    /**
     * A method to compare words
     * Used to sort the words by number of occurrences
     * @param o is specified word to compare
     * @return counter difference
     */
    @Override
    public int compareTo(Object o) {
        CounterWordDecorator temp = (CounterWordDecorator) o;
        return temp.getEntireCounter() - this.getEntireCounter();
    }
}

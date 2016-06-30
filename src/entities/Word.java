package entities;

/**
 * A class representing word
 * implements {@link Comparable} to be sorted
 */
public class Word implements Comparable{
    /**
     * value - word's text value
     * counter - number of occurrences
     */
    private String value;
    private int counter;

    /**
     * Constructor with value
     * @param value word's text value
     */
    public Word(String value) {
        this.value = value;
    }

    //Getters and setters

    public int getCounter() {
        return counter;
    }
    //Utility methods

    /**
     * A method to increase word's counter
     */
    public void increase(){
        counter++;
    }
    //Overridden methods

    /**
     * A method to represent word as a String object
     * @return word text representation
     */
    @Override
    public String toString(){
        return value;
    }

    /**
     * A method to check if words are equals
     * If text value is equals - words are equals
     * @param o is specified word to compare
     * @return true if links are the same
     * @return false if specified object is null
     * @return true if text values are equals
     */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null ) return false;
        Word tmp = (Word) o;
        return tmp.value.equals(this.value);
    }

    /**
     * A method to compare words
     * Used to sort the words by number of occurrences
     * @param o is specified word to compare
     * @return counter difference
     */
    @Override
    public int compareTo(Object o) {
        Word temp = (Word) o;
        return temp.getCounter() - this.getCounter();
    }

    /**
     * A method to correctly determine word hashcode
     * @return word hashcode
     */
    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + counter;
        return result;
    }
}

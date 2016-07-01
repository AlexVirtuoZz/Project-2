package entities;


/**
 * A class representing word
 * implements {@link Text}
 */
public class Word implements Text {
    /**
     * value - word's text value
     */
    private String value;

    /**
     * Constructor with value
     * @param value word's text value
     */
    public Word(String value) {
        this.value = value;
    }

    //Getters and setters

    //Utility methods
    /**
     * A method to convert standard word into decorated one
     * @return decorated word
     */
    public CounterWordDecorator decorateByCount(){
        return new CounterWordDecorator(this.value);
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
     * A method to correctly determine word hashcode
     * @return word hashcode
     */
    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result;
        return result;
    }
}

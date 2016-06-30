package entities;

/**
 * Created by HomePC1 on 29.06.2016.
 */
public class Word implements Comparable{
    private String value;
    private int counter;

    public Word(String value) {
        this.value = value;
    }

    public int getCounter() {
        return counter;
    }

    public void increase(){
        counter++;
    }

    @Override
    public String toString(){
        return value;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null ) return false;
        Word tmp = (Word) o;
        return tmp.value.equals(this.value);
    }

    @Override
    public int compareTo(Object o) {
        Word temp = (Word) o;
        return temp.getCounter() - this.getCounter();
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + counter;
        return result;
    }
}

package domain;

public class Number {

    private static final int INIT_NUMBER = 0;

    private int number;

    public Number() {
        this.number = INIT_NUMBER;
    }

    public int getNumber() {
        return number;
    }

    public void addNumber() {
        number++;
    }
}

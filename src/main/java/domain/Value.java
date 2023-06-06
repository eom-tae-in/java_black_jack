package domain;

public class Value {

    private final String value;
    private final int number;
    private int otherNumber;

    public Value(final String value, int number) {
        this.value = value;
        this.number = number;
    }

    public Value(String value, int number, int otherNumber) {
        this.value = value;
        this.number = number;
        this.otherNumber = otherNumber;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    public int getOtherNumber() {
        return otherNumber;
    }
}

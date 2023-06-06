package domain;

public class Value {

    private final String value;
    private final int number;
    private final int[] otherNumbers;

    public Value(final String value, int number, int ... otherNumbers) {
        this.value = value;
        this.number = number;
        this.otherNumbers = otherNumbers;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }

    public int[] getOtherNumbers() {
        return otherNumbers;
    }
}

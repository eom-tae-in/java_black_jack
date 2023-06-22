package domain;

public class Value {

    private final String value;
    private final int number;

    public Value(final String value, final int number) {
        this.value = value;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getValue() {
        return value;
    }
}

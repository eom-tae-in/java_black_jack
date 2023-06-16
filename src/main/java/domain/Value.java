package domain;

public class Value {

    private final String value;
    private final int number;

    public Value(final String value, int number) {
        this.value = value;
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public String getValue() {
        return this.value;
    }
}

package domain;

public class Value {

    private final String value;
    private final int[] numbers;

    public Value(String value, int ... numbers) {
        this.value = value;
        this.numbers = numbers;
    }

    public String getValue() {
        return value;
    }
}

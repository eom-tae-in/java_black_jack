package domain;

public class Value {
    private final String value;

    public Value(String value) {
        this.value = CardValue.validate(value);
    }

    public String getValue() {
        return value;
    }
}

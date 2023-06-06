package domain;

public enum CardValue {

    ACE(new Value(1, 11)),
    TWO(new Value(2)),
    THREE(new Value(3)),
    FOUR(new Value(4)),
    FIVE(new Value(5)),
    SIX(new Value(6)),
    SEVEN(new Value(7)),
    EIGHT(new Value(8)),
    NINE(new Value(9)),
    TEN(new Value(10)),
    JACK(new Value(10)),
    QUEEN(new Value(10)),
    KING(new Value(10));

    private final Value value;

    CardValue(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }
}

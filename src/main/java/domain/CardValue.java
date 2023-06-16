package domain;

public enum CardValue {

    TWO(new Value("2", 2)),
    THREE(new Value("3", 3)),
    FOUR(new Value("4",4)),
    FIVE(new Value("5",5)),
    SIX(new Value("6", 6)),
    SEVEN(new Value("7", 7)),
    EIGHT(new Value("8", 8)),
    NINE(new Value("9", 9)),
    TEN(new Value("10", 10)),
    JACK(new Value("J", 10)),
    QUEEN(new Value("Q", 10)),
    KING(new Value("K", 10)),
    ACE(new Value("A", 1));

    private final Value value;

    CardValue(Value value) {
        this.value = value;
    }

    public Value getValue() {
        return value;
    }
}

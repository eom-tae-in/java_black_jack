package domain;

import java.util.Arrays;

public enum CardValue {
    ACE(new Value("ace")),
    ONE(new Value("one")),
    TWO(new Value("two")),
    THREE(new Value("three")),
    FOUR(new Value("four")),
    FIVE(new Value("five")),
    SIX(new Value("six")),
    SEVEN(new Value("seven")),
    EIGHT(new Value("eight")),
    NINE(new Value("nine")),
    TEN(new Value("ten")),
    JACK(new Value("jack")),
    QUEEN(new Value("queen")),
    KING(new Value("king"));

    private final Value value;

    CardValue(Value value) {
        this.value = value;
    }

    static String validate(String cardValue) {
        return Arrays.stream(values()).filter(v -> v.value.getValue().equals(cardValue))
                .findAny().orElseThrow(IllegalArgumentException::new).value.getValue();
    }
}

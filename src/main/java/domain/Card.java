package domain;

public class Card {

    private final Shape shape;
    private final Value value;

    public Card(final Shape shape, final Value value) {
        this.shape = shape;
        this.value = value;
    }

    public Shape getShape() {
        return shape;
    }

    public Value getValue() {
        return value;
    }
}

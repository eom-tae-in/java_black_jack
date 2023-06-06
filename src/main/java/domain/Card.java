package domain;

public class Card {

    private final Shape shape;
    private final Value value;

    public Card(final Shape shape, final Value value) {
        this.shape = shape;
        this.value = value;
    }

    public String getShape() {
        return shape.getShape();
    }

    public String getValue() {
        return value.getValue();
    }

    public int getNumber() {
        return value.getNumber();
    }

    public int getOtherNumber() {
        return value.getOtherNumber();
    }
}

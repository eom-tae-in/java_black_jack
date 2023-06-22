package domain;

public class Card {

    private static final String ACE = "A";

    private final Shape shape;
    private final Value value;

    public Card(final Shape shape, final Value value) {
        this.shape = shape;
        this.value = value;
    }

    public int getNumber() {
        return value.getNumber();
    }

    public String getValue() {
        return value.getValue();
    }

    public String getValueAndShape() {
        return getValue() + shape.getShape();
    }

    public boolean isAce(final String value) {
        return value.equals(ACE);
    }
}

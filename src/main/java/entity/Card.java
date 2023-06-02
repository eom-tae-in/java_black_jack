package entity;

import domain.Shape;
import domain.Value;

public class Card {

    private final Shape shape;
    private final Value value;

    public Card(Shape shape, Value value) {
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

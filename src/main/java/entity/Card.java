package entity;

import domain.CardShape;
import domain.CardValue;
import domain.Shape;
import domain.Value;

public class Card {

    private final Shape shape;
    private final Value value;

    public Card(Shape shape, Value value) {
        this.shape = CardShape.validate(shape);
        this.value = CardValue.validate(value);
    }

    public Shape getShape() {
        return shape;
    }

    public Value getValue() {
        return value;
    }
}

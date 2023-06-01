package domain;

import java.util.Arrays;

public enum CardShape {
    SPADE(new Shape("spade")),
    HEART(new Shape("heart")),
    DIAMOND(new Shape("diamond")),
    CLOVER(new Shape("clover"));

    private final Shape shape;

    CardShape(Shape shape) {
        this.shape = shape;
    }

    static String validate(String cardShape) {
        return Arrays.stream(values()).filter(s -> s.shape.getShape().equals(cardShape))
                .findAny().orElseThrow(IllegalArgumentException::new).shape.getShape();

    }
}

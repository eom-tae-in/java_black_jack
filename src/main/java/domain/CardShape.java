package domain;

public enum CardShape {
    SPADE(new Shape("spade")),
    HEART(new Shape("heart")),
    DIAMOND(new Shape("diamond")),
    CLOVER(new Shape("clover"));

    private final Shape shape;

    CardShape(Shape shape) {
        this.shape = shape;
    }

    static Shape getShape(CardShape cardShape) {
        return cardShape.shape;
    }
}

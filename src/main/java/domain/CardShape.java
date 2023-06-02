package domain;

public enum CardShape {
    SPADE(new Shape("스페이드")),
    HEART(new Shape("하트")),
    DIAMOND(new Shape("다이아몬드")),
    CLOVER(new Shape("클로버"));

    private final Shape shape;

    CardShape(Shape shape) {
        this.shape = shape;
    }
}

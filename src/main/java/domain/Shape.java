package domain;

public class Shape {
    private final String shape;

    public Shape(String shape) {
        this.shape = CardShape.validate(shape);
    }

    public String getShape() {
        return shape;
    }
}

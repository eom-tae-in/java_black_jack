package entity;

public class Card {
    String shape;
    String value;

    public Card(String shape, String value) {
        this.shape = shape;
        this.value = value;
    }

    public String getShape() {
        return shape;
    }

    public String getValue() {
        return value;
    }
}

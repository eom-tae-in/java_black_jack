package domain;

public class DrawCardDto {

    private final Card first;
    private Card second;

    public DrawCardDto(final Card first) {
        this.first = first;
    }

    public DrawCardDto(final Card first, final Card second) {
        this.first = first;
        this.second = second;
    }

    public Card getFirst() {
        return first;
    }

    public Card getSecond() {
        return second;
    }
}

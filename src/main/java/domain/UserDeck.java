package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserDeck {

    private final List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public void add(DrawCardDto drawCardDto) {
        cards.add(drawCardDto.getFirst());
        if (drawCardDto.getSecond() != null) {
            cards.add(drawCardDto.getSecond());
        }
    }

    public int sum() {
        int sum = 0;
        for (Card c : cards) {
            sum += c.getValue().getValue();
        }
        return sum;
    }
}

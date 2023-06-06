package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class UserDeck {

    private static final String ACE = "A";

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
        swap();
        int sum = 0;
        for (Card c : cards) {
            sum += c.getNumber();
        }
        return sum;
    }

    public void swap() {
        int index = IntStream.range(0, cards.size())
                .filter(i -> cards.get(i).getValue().equals(ACE))
                .findAny().orElse(-1);
        if (index != -1) {
            Collections.swap(cards, index, cards.size() - 1);
        }
    }
}

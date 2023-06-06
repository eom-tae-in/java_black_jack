package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        int sum = 0;
        for (int i = 0; i < cards.size(); i++) {
            swapCard(cards.get(i), i);
        }
        return sum;
    }
}

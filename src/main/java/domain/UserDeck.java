package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class UserDeck {

    private static final String ACE = "A";
    private static final int NOT_EXIST_SPECIAL = -1;

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

    public int calculateSum() {
        int sum = 0;
        for (Card c : cards) {
            sum += c.getNumber();
        }
        return sum;
    }

    public int findSpecialIndex() {
        return IntStream.range(0, cards.size())
                .filter(i -> cards.get(i).getValue().equals(ACE))
                .findAny().orElse(NOT_EXIST_SPECIAL);
    }
}

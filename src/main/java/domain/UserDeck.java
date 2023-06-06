package domain;

import java.util.ArrayList;
import java.util.List;

public class UserDeck {

    private final List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }
}

package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParticipantDeck {

    private static final int LARGE_ACE_NUMBER = 11;
    private static final int SMALL_ACE_NUMBER = 1;
    private static final int BLACK_JACK = 21;

    private final List<Card> cards;

    public ParticipantDeck() {
        this.cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int sum() {
        int sum = calculateSum();
        if (findAce()) {
            return calculateSum();
        }
        return sum;
    }

    public int calculateSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getNumber();
        }
        return sum;
    }

    public boolean findAce() {
        return this.cards.stream()
                .anyMatch(card -> card.isAce(card.getValue()));
    }

    public int calculateMax(int sum) {
        int specialSum = sum + LARGE_ACE_NUMBER - SMALL_ACE_NUMBER;
        if (specialSum <= BLACK_JACK) {
            return specialSum;
        }
        return sum;
    }

    public Card getFirstCard() {
        return cards.get(0);
    }
}

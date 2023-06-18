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

    public void add(final Card card) {
        cards.add(card);
    }

    public int sum() {
        int sum = calculateSum();
        if (isContainAce()) {
            int specialSum = calculateSpecialSum(sum);
            return calculateMax(sum, specialSum);
        }
        return sum;
    }
    private int calculateSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getNumber();
        }
        return sum;
    }

    private boolean isContainAce() {
        return this.cards.stream()
                .anyMatch(card -> card.isAce(card.getValue()));
    }
    private int calculateMax(final int sum, final int specialSum) {
        if (specialSum <= BLACK_JACK) {
            return specialSum;
        }
        return sum;
    }

    private int calculateSpecialSum(final int sum) {
        return sum + LARGE_ACE_NUMBER - SMALL_ACE_NUMBER;
    }
}

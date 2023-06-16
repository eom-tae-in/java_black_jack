package domain;

import exception.NotFoundAceException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDeck {

    private static final String ACE = "A";
    private static final int LARGE_ACE_NUMBER = 11;
    private static final int SMALL_ACE_NUMBER = 1;
    private static final int BLACK_JACK = 21;

    private final List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }

    public void add(Card card) {
        cards.add(card);
    }

    public int sum() {
        int sum = calculateSum();
        try {
            findAce();
        } catch (NotFoundAceException e) {
            return sum;
        }
        return calculateMax(sum);
    }

    public int calculateSum() {
        int sum = 0;
        for (Card card : cards) {
            sum += card.getNumber();
        }
        return sum;
    }

    public void findAce() {
        this.cards.stream()
                .filter(card -> card.isAce(card.getValue())).findAny().orElseThrow(NotFoundAceException::new);
    }

    public int calculateMax(int sum) {
        int specialSum = sum + LARGE_ACE_NUMBER - SMALL_ACE_NUMBER;
        if (specialSum <= BLACK_JACK) {
            return specialSum;
        }
        return sum;
    }
}

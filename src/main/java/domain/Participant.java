package domain;

import java.util.List;

public abstract class Participant {

    private static final int BLACK_JACK = 21;

    private final Name name;
    private final Deck deck;

    public Participant(final Name name, final Deck deck) {
        this.name = name;
        this.deck = deck;
    }

    public void receiveCard(final Card card) {
        deck.add(card);
    }

    public String getName() {
        return name.getName();
    }

    public int getSum() {
        return deck.sum();
    }

    public List<Card> getDeck() {
        return deck.getCards();
    }

    public boolean isGameOver() {
        return deck.sum() > BLACK_JACK;
    }

    abstract public int getMoney();
}

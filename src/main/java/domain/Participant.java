package domain;

import java.util.List;

public abstract class Participant {

    private static final int BLACK_JACK = 21;

    private final Name name;
    private final ParticipantDeck participantDeck;

    public Participant(final Name name, final ParticipantDeck participantDeck) {
        this.name = name;
        this.participantDeck = participantDeck;
    }

    public void drawCard(Card card) {
        participantDeck.add(card);
    }

    public String getName() {
        return name.getName();
    }

    public int getSum() {
        return participantDeck.sum();
    }

    public List<Card> getDeck() {
        return participantDeck.getCards();
    }

    public Card getFirstCard() {
        return participantDeck.getFirstCard();
    }

    public boolean isGameOver() {
        return participantDeck.sum() > BLACK_JACK;
    }

    abstract public void addResult(Result result);
    abstract public String getResult();
}

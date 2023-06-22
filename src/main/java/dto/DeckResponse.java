package dto;

import domain.Card;
import domain.Participant;
import java.util.List;

public class DeckResponse {
    private final String name;
    private final List<Card> deck;

    public DeckResponse(final String name, final List<Card> deck) {
        this.name = name;
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public static DeckResponse toDto(final Participant participant) {
        return new DeckResponse(participant.getName(), participant.getDeck());
    }
}


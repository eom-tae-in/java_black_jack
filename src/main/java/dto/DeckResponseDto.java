package dto;

import domain.Card;
import domain.Participant;
import java.util.List;

public class DeckResponseDto {
    private final String name;
    private final List<Card> deck;

    public DeckResponseDto(final String name, final List<Card> deck) {
        this.name = name;
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public static DeckResponseDto toDto(final Participant participant) {
        return new DeckResponseDto(participant.getName(), participant.getDeck());
    }
}


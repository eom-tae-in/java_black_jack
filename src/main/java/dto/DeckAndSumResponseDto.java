package dto;

import domain.Card;
import domain.Participant;
import java.util.List;

public class DeckAndSumResponseDto {

    private final String name;
    private final List<Card> deck;
    private final int sum;

    public DeckAndSumResponseDto(final String name, final List<Card> deck, final int sum) {
        this.name = name;
        this.deck = deck;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public int getSum() {
        return sum;
    }

    public static DeckAndSumResponseDto toDto(final Participant participant) {
        return new DeckAndSumResponseDto(participant.getName(), participant.getDeck(), participant.getSum());
    }
}

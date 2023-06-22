package domain;

import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Arrays;
import static exception.CardMessage.NO_MORE_CARD_EXCEPTION;

public class CardDeck {

    private final Queue<Card> cardDeck;

    private CardDeck(final Queue<Card> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public static CardDeck create() {
        ArrayList<Card> cards = generate();
        Collections.shuffle(cards);
        return new CardDeck(new LinkedList<>(cards));
    }

    private static ArrayList<Card> generate() {
        ArrayList<Card> cards = new ArrayList<>();
        Arrays.stream(CardShape.values())
                .forEach(cardShape -> Arrays.stream(CardValue.values())
                .forEach(cardValue -> cards.add(new Card(cardShape.getShape(), cardValue.getValue()))));
        return cards;
    }

    public Card draw() {
        if (cardDeck.isEmpty()) {
            throw new RuntimeException(NO_MORE_CARD_EXCEPTION.getMessage());
        }
        return cardDeck.poll();
    }
}

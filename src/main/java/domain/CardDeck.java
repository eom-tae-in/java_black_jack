package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CardDeck {

    private final Queue<Card> cardDeck = new LinkedList<>();

    public Queue<Card> getCardDeck() {
        return cardDeck;
    }

    public ArrayList<Card> generate() {
        ArrayList<Card> cards = new ArrayList<>();
        Arrays.stream(CardShape.values()).forEach(cardShape -> Arrays.stream(CardValue.values())
                .forEach(cardValue -> cards.add(new Card(cardShape.getShape(), cardValue.getValue()))));
        return cards;
    }
}

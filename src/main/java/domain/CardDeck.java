package domain;

import exception.NotExistCardException;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Arrays;

public class CardDeck {

    private final Queue<Card> cardDeck;

    private CardDeck(Queue<Card> cardDeck) {
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
            throw new NotExistCardException("더 이상 뽑을 카드가 없습니다.");
        }
        return cardDeck.poll();
    }
}

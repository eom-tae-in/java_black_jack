package domain;

import java.util.*;
import java.util.stream.IntStream;

public class CardDeck {

    private final Queue<Card> cardDeck = new LinkedList<>();

    public Queue<Card> getCardDeck() {
        return cardDeck;
    }

     ArrayList<Card> generate() {
        ArrayList<Card> cards = new ArrayList<>();
        Arrays.stream(CardShape.values()).forEach(cardShape -> Arrays.stream(CardValue.values())
                .forEach(cardValue -> cards.add(new Card(cardShape.getShape(), cardValue.getValue()))));
        return cards;
    }

    public void ready() {
        ArrayList<Card> generatedDeck = generate();
        Collections.shuffle(generatedDeck);
        cardDeck.addAll(generatedDeck);
    }

    public DrawCardDto drawFirst() {
        return new DrawCardDto(cardDeck.poll(), cardDeck.poll());
    }

    public DrawCardDto draw() {
        return new DrawCardDto(cardDeck.poll());
    }
}

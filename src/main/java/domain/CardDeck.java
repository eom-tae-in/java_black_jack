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

    public List<Card> drawFirst() {
        return new ArrayList<>(){{ IntStream.range(0,2).forEach(i -> { add(cardDeck.poll());});
        }};}
}

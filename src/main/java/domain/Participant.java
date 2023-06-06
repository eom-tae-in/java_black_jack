package domain;

public class Participant {

    private final Name name;
    private final UserDeck userDeck;
    private final CardDeck cardDeck;

    public Participant(Name name, UserDeck userDeck, CardDeck cardDeck) {
        this.name = name;
        this.userDeck = userDeck;
        this.cardDeck = cardDeck;
    }

    public static Participant Dealer(UserDeck userDeck, CardDeck cardDeck) {
        return new Participant(new Name("dealer"), userDeck, cardDeck);
    }

    public int getSum() {
        return this.userDeck.sum();
    }

    public void getAdd(DrawCardDto drawCardDto) {
        this.userDeck.add(drawCardDto);
    }

    public DrawCardDto getDraw() {
        return this.cardDeck.draw();
    }

    public int getCalculateSum() {
        return this.userDeck.calculateSum();
    }
}

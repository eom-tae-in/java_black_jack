package domain;

public class Player {

    private final Name name;
    private final UserDeck userDeck;
    private final CardDeck cardDeck;

    public Player(final Name name, final UserDeck userDeck, final CardDeck cardDeck) {
        this.name = name;
        this.userDeck = userDeck;
        this.cardDeck = cardDeck;
    }

    public Name getName() {
        return name;
    }

    public UserDeck getUserDeck() {
        return userDeck;
    }
}

package domain;

public class Player {

    private static final int BLACK_JACK = 21;

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

    public void drawCard(String answer) {
        if (answer.equals("y")) {
            userDeck.add(cardDeck.draw());
        }
    }

    public boolean isGameOver() {
        return userDeck.sum() > BLACK_JACK;
    }
}

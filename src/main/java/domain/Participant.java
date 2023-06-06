package domain;

public class Participant {

    private final Name name;
    private final UserDeck userDeck;
    private final CardDeck cardDeck;
    private final Result result = new Result(0, 0, 0);

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

    public void add(DrawCardDto drawCardDto) {
        this.userDeck.add(drawCardDto);
    }

    public DrawCardDto getDraw() {
        return this.cardDeck.draw();
    }

    public int getCalculateSum() {
        return this.userDeck.calculateSum();
    }

    public String getName() {
        return name.getName();
    }

    public void addWin() {
        this.result.addWin();
    }

    public void addDrew() {
        this.result.addDrew();
    }

    public void addLose() {
        this.result.addLose();
    }
}

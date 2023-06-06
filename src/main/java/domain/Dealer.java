package domain;

public class Dealer {

    private static final int BLACK_JACK = 21;

    private final Participant participant;

    public Dealer(Participant participant) {
        this.participant = participant;
    }
}

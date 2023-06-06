package domain;

public class Dealer {

    private static final int BLACK_JACK = 21;

    private final Participant participant;

    public Dealer(Participant participant) {
        this.participant = participant;
    }

    public void drawCard() {
        if (participant.getSum() <= 16) {
            participant.getAdd(participant.getDraw());
        }
    }
}

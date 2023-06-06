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

    public boolean isGameOver() {
        return participant.getCalculateSum() > BLACK_JACK;
    }

    public void getCard(DrawCardDto drawCardDto) {
        participant.getAdd(drawCardDto);
    }
}

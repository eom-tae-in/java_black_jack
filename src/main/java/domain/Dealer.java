package domain;

import java.util.List;

public class Dealer {

    private static final int BLACK_JACK = 21;

    private final Participant participant;

    public Dealer(Participant participant) {
        this.participant = participant;
    }

    public void drawCard() {
        participant.add(participant.getDraw());
    }

    public boolean isMoreCard() {
        return participant.getSum() <= 16;
    }

    public boolean isGameOver() {
        return participant.getCalculateSum() > BLACK_JACK;
    }

    public void getCard(DrawCardDto drawCardDto) {
        participant.add(drawCardDto);
    }

    public int getSum() {
        return participant.getSum();
    }

    public void win() {
        participant.addWin();
    }

    public void drew() {
        participant.addDrew();
    }

    public void lose() {
        participant.addLose();
    }

    public List<Card> getDeck() {
        return participant.getUserDeck();
    }

    public String getName() {
        return participant.getName();
    }

    public Result getResult() {
        return participant.getResult();
    }
}

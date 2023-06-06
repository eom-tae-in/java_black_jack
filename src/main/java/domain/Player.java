package domain;

public class Player {

    private static final int BLACK_JACK = 21;

    private final Participant participant;

    public Player(Participant participant) {
        this.participant = participant;
    }

    public void drawCard(String answer) {
        if (answer.equals("y")) {
            participant.add(participant.getDraw());
        }
    }

    public boolean isGameOver() {
        return participant.getCalculateSum() > BLACK_JACK;
    }

    public void getCard(DrawCardDto drawCardDto) {
        participant.add(drawCardDto);
    }

    public String getName() {
        return participant.getName();
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
}

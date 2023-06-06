package domain;

public class Player {

    private static final int BLACK_JACK = 21;

    private final Participant participant;

    public Player(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }

    public void drawCard(String answer) {
        if (answer.equals("y")) {
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

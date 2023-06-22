package domain;

public class Player extends Participant {

    private Result result;

    public Player(final Name name, final ParticipantDeck participantDeck) {
        super(name, participantDeck);
        this.result = Result.NONE;
    }

    @Override
    public void addResult(final Result result) {
        this.result = result;
    }

    @Override
    public String getResult() {
        return result.getResult();
    }
}

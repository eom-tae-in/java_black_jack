package domain;

import static domain.Result.*;

public class Dealer extends Participant {

    private static final int DEALER_MINIMUM_NUMBER = 16;
    private static final int NEVER = 0;
    private static final String BLANK = " ";

    private final Results results;


    public Dealer(Name name, ParticipantDeck participantDeck, Results results) {
        super(name, participantDeck);
        this.results = results;
    }

    public boolean isMoreCard() {
        return getSum() <= DEALER_MINIMUM_NUMBER;
    }

    public String getFirstCardValue() {
        return getFirstCard().getValueAndShape();
    }

    @Override
    public void addResult(Result result) {
        results.addResult(result);
    }

    @Override
    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        if (results.getWin() != NEVER) {
            stringBuilder.append(results.getWin() + WIN.getResult() + BLANK);
        }
        if (results.getDraw() != NEVER) {
            stringBuilder.append(results.getDraw() + DRAW.getResult() + BLANK);
        }
        if (results.getLose() != NEVER) {
            stringBuilder.append(results.getLose() + LOSE.getResult());
        }
        return String.valueOf(stringBuilder);
    }
}

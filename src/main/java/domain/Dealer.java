package domain;

import exception.CardDeckEmptyException;
import static domain.Result.DRAW;
import static domain.Result.LOSE;
import static domain.Result.WIN;

public class Dealer extends Participant {

    private static final int DEALER_MINIMUM_NUMBER = 16;
    private static final int NEVER = 0;
    private static final String BLANK = " ";
    private static final int FIRST_CARD_INDEX = 0;
    private static final String CARD_DECK_IS_EMPTY = "받은 카드가 없습니다.";

    private final Results results;


    public Dealer(final Name name, final ParticipantDeck participantDeck, final Results results) {
        super(name, participantDeck);
        this.results = results;
    }

    public boolean canGetMoreCard() {
        return getSum() <= DEALER_MINIMUM_NUMBER;
    }

    public String getFirstCardValue() {
        return getFirstCard().getValueAndShape();
    }

    public Card getFirstCard() {
        if (getDeck().isEmpty()) {
            throw new CardDeckEmptyException(CARD_DECK_IS_EMPTY);
        }
        return getDeck().get(FIRST_CARD_INDEX);
    }

    @Override
    public void addResult(final Result result) {
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

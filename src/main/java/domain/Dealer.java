package domain;

import dto.ResultDto;

public class Dealer extends Participant{

    private static final int DEALER_MINIMUM_NUMBER = 16;
    private static final int NEVER = 0;
    private static final String WIN = "승";
    private static final String DREW = "무";
    private static final String LOSE = "패";


    public Dealer(Name name, ResultDto resultDto, ParticipantDeck participantDeck) {
        super(name, resultDto, participantDeck);
    }

    @Override
    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        if (super.getWin() != NEVER) {
            stringBuilder.append(super.getWin() + WIN + " ");
        }
        if (super.getDrew() != NEVER) {
            stringBuilder.append(super.getDrew() + DREW + " ");
        }
        if (super.getLose() != NEVER) {
            stringBuilder.append(super.getLose() + LOSE);
        }
        return String.valueOf(stringBuilder);
    }

    public boolean isMoreCard() {
        return super.getSum() <= DEALER_MINIMUM_NUMBER;
    }

    public Card showOnlyOne() {
        return super.getDeck().get(0);
    }
}

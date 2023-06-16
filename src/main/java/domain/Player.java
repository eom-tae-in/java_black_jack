package domain;

import dto.ResultDto;

public class Player extends Participant {
    private static final int NEVER = 0;
    private static final String WIN = "승";
    private static final String DREW = "무";
    private static final String LOSE = "패";

    private Answer answer;

    public Player(Name name, ResultDto resultDto, ParticipantDeck participantDeck) {
        super(name, resultDto, participantDeck);
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer.getAnswer();
    }

    @Override
    public String getResult() {
        if (super.getWin() != NEVER) {
            return WIN;
        }
        if (super.getLose() != NEVER) {
            return LOSE;
        }
        return DREW;
    }
}

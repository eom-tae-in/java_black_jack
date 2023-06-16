package domain;

import dto.ResultDto;

import java.util.List;

public abstract class Participant {

    private final Name name;
    private final ResultDto resultDto;
    private final ParticipantDeck participantDeck;

    public Participant(Name name, ResultDto resultDto, ParticipantDeck participantDeck) {
        this.name = name;
        this.resultDto = resultDto;
        this.participantDeck = participantDeck;
    }

    public void drawCard(Card card) {
        participantDeck.add(card);
    }
    public String getName() {
        return name.getName();
    }

    public int getSum() {
        return participantDeck.sum();
    }

    public int getWin() {
        return resultDto.getWin();
    }

    public int getDrew() {
        return resultDto.getDrew();
    }

    public int getLose() {
        return resultDto.getLose();
    }

    public void win() {
        resultDto.addWin();
    }

    public void drew() {
        resultDto.addDrew();
    }

    public void lose() {
        resultDto.addLose();
    }

    public List<Card> getDeck() {
        return participantDeck.getCards();
    }


    abstract public String getResult();
}

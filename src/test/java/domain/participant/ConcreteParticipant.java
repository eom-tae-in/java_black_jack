package domain.participant;

import domain.Name;
import domain.Participant;
import domain.ParticipantDeck;
import domain.Result;

class ConcreteParticipant extends Participant {

    public ConcreteParticipant(final Name name, final ParticipantDeck participantDeck) {
        super(name, participantDeck);
    }

    @Override
    public void addResult(final Result result) {
    }

    @Override
    public String getResult() {
        return null;
    }
}

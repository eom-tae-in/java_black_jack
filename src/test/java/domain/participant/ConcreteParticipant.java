package domain.participant;

import domain.Name;
import domain.Participant;
import domain.Deck;

class ConcreteParticipant extends Participant {

    public ConcreteParticipant(final Name name, final Deck deck) {
        super(name, deck);
    }

    @Override
    public int getMoney() {
        return 0;
    }
}

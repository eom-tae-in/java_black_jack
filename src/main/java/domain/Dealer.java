package domain;

import static exception.CardMessage.EMPTY_CARD_DECK_EXCEPTION;

public class Dealer extends Participant {

    private static final int DEALER_MINIMUM_NUMBER = 16;
    private static final int FIRST_CARD_INDEX = 0;

    private final Amount amount;

    public Dealer(final Name name, final Deck deck, final Amount amount) {
        super(name, deck);
        this.amount = amount;
    }

    public boolean canGetMoreCard() {
        return getSum() <= DEALER_MINIMUM_NUMBER;
    }

    public String getFirstCardValue() {
        return getFirstCard().getValueAndShape();
    }

    public Card getFirstCard() {
        if (getDeck().isEmpty()) {
            throw new RuntimeException(EMPTY_CARD_DECK_EXCEPTION.getMessage());
        }
        return getDeck().get(FIRST_CARD_INDEX);
    }

    public void changeAmount(final ProfitRate profitRate, final int battingAmount) {
        amount.addProfitOrLoss(profitRate, battingAmount);
    }

    @Override
    public int getMoney() {
        return amount.getAmount();
    }
}

package domain;

public class Player extends Participant {

    private final Money money;

    public Player(final Name name, final Deck deck, final Money money) {
        super(name, deck);
        this.money = money;
    }

    public void calculateProfitOrLoss(final ProfitRate profitRate) {
        money.setMoney(profitRate.multiply(money.getMoney()));
    }

    public void setMoney(final int battingMoney) {
        money.setMoney(battingMoney);
    }

    @Override
    public int getMoney() {
        return money.getMoney();
    }
}

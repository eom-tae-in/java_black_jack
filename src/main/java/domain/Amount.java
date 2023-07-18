package domain;

public class Amount {

    private int amount;

    public void addProfitOrLoss(final ProfitRate profitRate, final int battingAmount) {
        amount += profitRate.multiply(battingAmount);
    }

    public int getAmount() {
        return amount;
    }
}

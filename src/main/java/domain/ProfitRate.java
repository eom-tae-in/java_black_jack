package domain;

public enum ProfitRate {

    WIN(1),
    DRAW(0),
    LOSE(-1),
    BLACK_JACK(1.5),
    BOTH_BLACK_JACK(1);

    private final double profitRate;

    ProfitRate(final double profitRate) {
        this.profitRate = profitRate;
    }

    public int multiply(final int battingAmount) {
        return (int) (battingAmount * profitRate);
    }
}

package domain;

public class Referee {

    private static final int BLACK_JACK = 21;

    public void decideResult(Player player, Dealer dealer) {
        if (isPlayerWin(player.getSum(), dealer.getSum())) {
            playerWin(player, dealer);
            return;
        }
        if (isDealerWin(player.getSum(), dealer.getSum())) {
            dealerWin(player, dealer);
            return;
        }
        drew(player, dealer);
    }

    private boolean isPlayerWin(int playerSum, int dealerSum) {
        return playerSum > dealerSum || dealerSum > BLACK_JACK;
    }

    private boolean isDealerWin(int playerSum, int dealerSum) {
        return playerSum < dealerSum || playerSum > BLACK_JACK;
    }
    private void playerWin(Player player, Dealer dealer) {
        player.win();
        dealer.lose();
    }

    private void dealerWin(Player player, Dealer dealer) {
        dealer.win();
        player.lose();
    }

    private void drew(Player player, Dealer dealer) {
        dealer.drew();
        player.drew();
    }
}

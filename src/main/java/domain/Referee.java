package domain;

import dto.RefereeResultResponse;
import static domain.ProfitRate.BOTH_BLACK_JACK;
import static domain.ProfitRate.DRAW;
import static domain.ProfitRate.LOSE;
import static domain.ProfitRate.WIN;

public class Referee {

    private static final int BLACK_JACK = 21;

    public RefereeResultResponse decideResult(final int dealerSum, final int playerSum) {
        if (isPlayerWin(dealerSum, playerSum)) {
            return playerWin(playerSum);
        }
        if (isDealerWin(dealerSum, playerSum)) {
            return dealerWin(dealerSum);
        }
        return draw(dealerSum, playerSum);
    }

    private boolean isBlackJack(final int sum) {
        return sum == BLACK_JACK;
    }

    private boolean isPlayerWin(final int dealerSum, final int playerSum) {
        return dealerSum > BLACK_JACK || (playerSum > dealerSum && playerSum <= BLACK_JACK);
    }

    private boolean isDealerWin(final int dealerSum, final int playerSum) {
        return playerSum > BLACK_JACK || (playerSum < dealerSum && dealerSum <= BLACK_JACK);
    }

    private RefereeResultResponse playerWin(final int playerSum) {
        if (isBlackJack(playerSum)) {
            return new RefereeResultResponse(ProfitRate.BLACK_JACK, LOSE);
        }
        return new RefereeResultResponse(WIN, LOSE);
    }

    private RefereeResultResponse dealerWin(final int dealerSum) {
        if (isBlackJack(dealerSum)) {
            return new RefereeResultResponse(LOSE, ProfitRate.BLACK_JACK);
        }
        return new RefereeResultResponse(LOSE, WIN);
    }

    private RefereeResultResponse draw(final int playerSum, final int dealerSum) {
        if (isBlackJack(playerSum) && isBlackJack(dealerSum)) {
            return new RefereeResultResponse(BOTH_BLACK_JACK, BOTH_BLACK_JACK);
        }
        return new RefereeResultResponse(DRAW, DRAW);
    }
}

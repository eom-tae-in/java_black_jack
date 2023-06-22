package domain;

import dto.RefereeResultResponseDto;
import static domain.Result.DRAW;
import static domain.Result.LOSE;
import static domain.Result.WIN;

public class Referee {

    private static final int BLACK_JACK = 21;

    public RefereeResultResponseDto decideResult(final int dealerSum, final int playerSum) {
        if (isPlayerWin(playerSum, dealerSum)) {
            return playerWin();
        }
        if (isDealerWin(playerSum, dealerSum)) {
            return dealerWin();
        }
        return draw();
    }

    private boolean isPlayerWin(final int playerSum, final int dealerSum) {
        return playerSum > dealerSum || dealerSum > BLACK_JACK;
    }

    private boolean isDealerWin(final int playerSum, final int dealerSum) {
        return playerSum < dealerSum || playerSum > BLACK_JACK;
    }

    private RefereeResultResponseDto playerWin() {
        return new RefereeResultResponseDto(WIN, LOSE);
    }

    private RefereeResultResponseDto dealerWin() {
        return new RefereeResultResponseDto(LOSE, WIN);
    }

    private RefereeResultResponseDto draw() {
        return new RefereeResultResponseDto(DRAW, DRAW);
    }
}

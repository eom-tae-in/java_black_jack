package domain;

import dto.RefereeResultResponseDto;

public class Referee {

    private static final int BLACK_JACK = 21;

    public RefereeResultResponseDto decideResult(int dealerSum, int playerSum) {
        if (isPlayerWin(playerSum, dealerSum)) {
            return playerWin();
        }
        if (isDealerWin(playerSum, dealerSum)) {
            return dealerWin();
        }
        return draw();
    }

    private boolean isPlayerWin(int playerSum, int dealerSum) {
        return playerSum > dealerSum || dealerSum > BLACK_JACK;
    }

    private boolean isDealerWin(int playerSum, int dealerSum) {
        return playerSum < dealerSum || playerSum > BLACK_JACK;
    }

    private RefereeResultResponseDto playerWin() {
        return new RefereeResultResponseDto(Result.WIN, Result.LOSE);
    }

    private RefereeResultResponseDto dealerWin() {
        return new RefereeResultResponseDto(Result.LOSE, Result.WIN);
    }

    private RefereeResultResponseDto draw() {
        return new RefereeResultResponseDto(Result.DRAW, Result.DRAW);
    }
}

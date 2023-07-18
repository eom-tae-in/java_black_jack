package dto;

import domain.ProfitRate;

public class RefereeResultResponse {

    private final ProfitRate playerProfitRate;
    private final ProfitRate dealerProfitRate;

    public RefereeResultResponse(final ProfitRate playerProfitRate, final ProfitRate dealerProfitRate) {
        this.playerProfitRate = playerProfitRate;
        this.dealerProfitRate = dealerProfitRate;
    }

    public ProfitRate getPlayerResult() {
        return playerProfitRate;
    }

    public ProfitRate getDealerResult() {
        return dealerProfitRate;
    }
}

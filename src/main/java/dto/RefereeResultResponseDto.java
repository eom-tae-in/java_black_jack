package dto;

import domain.Result;

public class RefereeResultResponseDto {

    private final Result playerResult;
    private final Result dealerResult;

    public RefereeResultResponseDto(Result playerResult, Result dealerResult) {
        this.playerResult = playerResult;
        this.dealerResult = dealerResult;
    }

    public Result getPlayerResult() {
        return playerResult;
    }

    public Result getDealerResult() {
        return dealerResult;
    }
}

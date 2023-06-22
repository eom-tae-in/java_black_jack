package dto;

import domain.Participant;

public class ResultResponse {

    private final String name;
    private final int profit;

    public ResultResponse(final String name, final int profit) {
        this.name = name;
        this.profit = profit;
    }

    public String getName() {
        return name;
    }

    public int getProfit() {
        return profit;
    }

    public static ResultResponse toDto(final Participant participant) {
        return new ResultResponse(participant.getName(), participant.getMoney());
    }
}

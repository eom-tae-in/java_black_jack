package dto;

import domain.Participant;

public class ResultResponseDto {

    private final String name;
    private final String result;

    public ResultResponseDto(final String name, final String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public static ResultResponseDto toDto(final Participant participant) {
        return new ResultResponseDto(participant.getName(), participant.getResult());
    }
}

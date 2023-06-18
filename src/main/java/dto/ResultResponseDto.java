package dto;

import domain.Participant;

public class ResultResponseDto {

    private final String name;
    private final String result;

    public ResultResponseDto(String name, String result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    public static ResultResponseDto toDto(Participant participant) {
        return new ResultResponseDto(participant.getName(), participant.getResult());
    }
}

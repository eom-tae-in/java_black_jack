package dto;

import domain.Dealer;

public class OnlyOneCardResponseDto {

    private final String name;
    private final String value;

    public OnlyOneCardResponseDto(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static OnlyOneCardResponseDto toDto(Dealer dealer) {
        return new OnlyOneCardResponseDto(dealer.getName(), dealer.getFirstCardValue());
    }
}

package dto;

import domain.Dealer;

public class OnlyOneCardResponseDto {

    private final String name;
    private final String value;

    public OnlyOneCardResponseDto(final String name,final String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static OnlyOneCardResponseDto toDto(final Dealer dealer) {
        return new OnlyOneCardResponseDto(dealer.getName(), dealer.getFirstCardValue());
    }
}

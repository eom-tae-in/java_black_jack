package dto;

import domain.Dealer;

public class CardResponse {

    private final String name;
    private final String value;

    public CardResponse(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static CardResponse toDto(final Dealer dealer) {
        return new CardResponse(dealer.getName(), dealer.getFirstCardValue());
    }
}

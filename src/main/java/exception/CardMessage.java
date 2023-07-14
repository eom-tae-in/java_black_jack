package exception;

public enum CardMessage {

    NO_MORE_CARD_EXCEPTION("더 이상 받을 카드가 없습니다."),
    EMPTY_CARD_DECK_EXCEPTION("받은 카드가 없습니다.");
    private final String message;

    CardMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package exception;

public class CardDeckEmptyException extends IllegalArgumentException {
    public CardDeckEmptyException(final String message) {
        super(message);
    }
}

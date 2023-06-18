package exception;

public class NotFoundAceException extends IllegalArgumentException {
    public NotFoundAceException(final String message) {
        super(message);
    }
}

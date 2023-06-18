package exception;

public class NotFoundAceException extends IllegalArgumentException {
    public NotFoundAceException(String message) {
        super(message);
    }
}

package exception;

public class InputEmptyException extends IllegalArgumentException {
    public InputEmptyException(final String message) {
        super(message);
    }
}

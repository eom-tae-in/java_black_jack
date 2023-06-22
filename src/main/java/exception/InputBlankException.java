package exception;

public class InputBlankException extends IllegalArgumentException{
    public InputBlankException(final String message) {
        super(message);
    }
}

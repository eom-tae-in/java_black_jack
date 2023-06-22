package exception;

public class WrongInputException extends IllegalArgumentException {
    public WrongInputException(final String message) {
        super(message);
    }
}

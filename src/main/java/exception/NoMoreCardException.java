package exception;

public class NoMoreCardException extends IllegalArgumentException{
    public NoMoreCardException(final String message) {
        super(message);
    }
}

package exception;

public class EmptyCardDeckException extends IllegalArgumentException{
    public EmptyCardDeckException(String message) {
        super(message);
    }
}

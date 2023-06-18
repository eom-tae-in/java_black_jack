package exception;

public class NotExistCardException extends IllegalArgumentException{
    public NotExistCardException(String message) {
        super(message);
    }
}

package dto;

public class InputEmptyException extends IllegalArgumentException {
    public InputEmptyException(String message) {
        super(message);
    }
}

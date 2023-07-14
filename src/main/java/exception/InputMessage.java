package exception;

public enum InputMessage {

    WRONG_INPUT_EXCEPTION("입력이 올바르지 않습니다. 다시 입력해주세요.");

    private final String message;

    InputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

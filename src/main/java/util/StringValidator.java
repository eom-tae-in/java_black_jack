package util;

import static exception.InputMessage.WRONG_INPUT_EXCEPTION;

public class StringValidator {

    public static void validation(final String text) {
        checkNull(text);
        checkNotBlank(text);
    }

    private static void checkNull(final String answer) {
        if (answer == null) {
            throw new NullPointerException(WRONG_INPUT_EXCEPTION.getMessage());
        }
    }

    private static void checkNotBlank(final String answer) {
        if (answer.isBlank()) {
            throw new IllegalArgumentException(WRONG_INPUT_EXCEPTION.getMessage());
        }
    }
}

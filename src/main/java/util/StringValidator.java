package util;

import exception.InputBlankException;
import exception.InputEmptyException;

public class StringValidator {

    private static final String WRONG_INPUT = "입력이 올바르지 않습니다. 다시 입력해주세요.";

    public static void validation(final String answer) {
        checkNull(answer);
        checkEmpty(answer);
        checkNotBlank(answer);
    }

    private static void checkNull(final String answer) {
        if (answer == null) {
            throw new NullPointerException(WRONG_INPUT);
        }
    }

    private static void checkEmpty(final String answer) {
        if (answer.isEmpty()) {
            throw new InputEmptyException(WRONG_INPUT);
        }
    }

    private static void checkNotBlank(final String answer) {
        if (answer.isBlank()) {
            throw new InputBlankException(WRONG_INPUT);
        }
    }
}

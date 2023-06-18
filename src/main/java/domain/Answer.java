package domain;

import dto.InputBlankException;
import dto.InputEmptyException;
import exception.WrongInputException;

public class Answer {

    private static final String YES = "y";
    private static final String NO = "n";
    private static final String WRONG_INPUT = "입력이 올바르지 않습니다. 다시 입력해주세요.";


    public static boolean isYes(final String answer) {
        return answer.equals(YES);
    }

    public static void validation(final String answer) {
        checkNull(answer);
        checkEmpty(answer);
        checkNotBlank(answer);
    }

    public static void checkYesOrNo(final String answer) {
        if (!answer.equals(YES) && !answer.equals(NO)) {
            throw new WrongInputException(WRONG_INPUT);
        }
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

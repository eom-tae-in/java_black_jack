package domain;

import exception.InputMessage;
import util.StringValidator;

public class Answer {

    private static final String YES = "y";
    private static final String NO = "n";

    public static boolean isYes(final String answer) {
        return answer.equals(YES);
    }

    public static void validation(final String answer) {
        StringValidator.validation(answer);
        checkYesOrNo(answer);
    }
    private static void checkYesOrNo(final String answer) {
        if (!answer.equals(YES) && !answer.equals(NO)) {
            throw new IllegalArgumentException(InputMessage.WRONG_INPUT_EXCEPTION.getMessage());
        }
    }
}

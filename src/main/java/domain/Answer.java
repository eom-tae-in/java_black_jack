package domain;

import exception.WrongInputException;
import util.StringValidator;

public class Answer {

    private static final String YES = "y";
    private static final String NO = "n";
    private static final String WRONG_INPUT = "입력이 올바르지 않습니다. 다시 입력해주세요.";

    public static boolean isYes(final String answer) {
        return answer.equals(YES);
    }

    public static void validation(final String answer) {
        StringValidator.validation(answer);
        checkYesOrNo(answer);
    }
    private static void checkYesOrNo(final String answer) {
        if (!answer.equals(YES) && !answer.equals(NO)) {
            throw new WrongInputException(WRONG_INPUT);
        }
    }
}

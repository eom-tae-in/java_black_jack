package view;

import exception.WrongInputException;

public class Validation {
    private static final String WRONG_INPUT = "입력이 올바르지 않습니다. 다시 입력해주세요.";

    public void checkGetMoreInput(String answer) {
        if (!answer.equals("y") && !answer.equals("n")) {
            throw new WrongInputException(WRONG_INPUT);
        }
    }
}

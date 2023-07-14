package view;

import domain.Answer;

import java.util.Scanner;

public class InputView {

    private static final String COMMA = ",";
    private static final String INPUT_ONLY_NUMBER = "숫자만 입력해주세요.";

    private final static Scanner input = new Scanner(System.in);

    public String[] receiveName() {
        try {
            String name = input.nextLine();
            InputViewValidator.validateString(name);
            return name.split(COMMA);
        } catch (IllegalArgumentException | NullPointerException e) {
            System.out.println(e.getMessage());
            return receiveName();
        }
    }

    public String receiveAnswer() {
        try {
            String answer = input.next();
            Answer.validation(answer);
            return answer;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return receiveAnswer();
        }
    }

    public int receiveMoney() {
        try {
            String money = input.next();
            return InputViewValidator.validateStringToInt(money);
        } catch (NumberFormatException e) {
            System.out.println(INPUT_ONLY_NUMBER);
            return receiveMoney();
        }
    }
}

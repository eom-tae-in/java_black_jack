package view;

import domain.Answer;
import dto.PlayerNameRequestDto;
import exception.WrongInputException;
import java.util.Scanner;

public class InputView {

    private static final String COMMA = ",";

    private final Scanner input;

    public InputView() {
        this.input = new Scanner(System.in);
    }

    public String[] getName() {
        try {
            String name = input.nextLine();
            Answer.validation(name);
            return name.split(COMMA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getName();
        }
    }

    public String getMore() {
        try {
            String answer = input.next();
            Answer.checkYesOrNo(answer);
            return answer;
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
            return getMore();
        }
    }
}

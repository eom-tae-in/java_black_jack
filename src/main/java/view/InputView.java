package view;

import domain.Answer;
import exception.WrongInputException;
import java.util.Scanner;

public class InputView {

    private static final String COMMA = ",";

    private final Scanner input;
    private final Validation validation;

    public InputView() {
        this.input = new Scanner(System.in);
        this.validation = new Validation();
    }

    public String[] getName() {
        try {
            String name = input.nextLine();
            return name.split(COMMA);
        } catch (RuntimeException e) {
            return getName();
        }
    }

    public Answer getMore() {
        try {
            String answer = input.next();
            validation.checkGetMoreInput(answer);
            return new Answer(answer);
        } catch (WrongInputException e) {
            return getMore();
        }
    }
}

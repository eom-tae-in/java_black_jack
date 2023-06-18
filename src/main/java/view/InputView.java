package view;

import domain.Answer;
import exception.InputBlankException;
import exception.InputEmptyException;
import exception.WrongInputException;
import util.StringValidator;
import java.util.Scanner;

public class InputView {

    private static final String COMMA = ",";

    private final static Scanner input = new Scanner(System.in);

    public static String[] receiveName() {
        try {
            String name = input.nextLine();
            StringValidator.validation(name);
            return name.split(COMMA);
        } catch (InputBlankException | InputEmptyException | NullPointerException e) {
            System.out.println(e.getMessage());
            return receiveName();
        }
    }

    public static String receiveAnswer() {
        try {
            String answer = input.next();
            Answer.validation(answer);
            return answer;
        } catch (WrongInputException | InputBlankException | InputEmptyException | NullPointerException e) {
            System.out.println(e.getMessage());
            return receiveAnswer();
        }
    }
}

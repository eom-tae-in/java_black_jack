package view;

import exception.WrongInputException;

import java.util.Scanner;

public class InputView {

    private Scanner sc = new Scanner(System.in);
    private final Validation validation = new Validation();

    public String[] getName() {
        try {
            String name = sc.nextLine();
            return name.split(",");
        } catch (RuntimeException e) {
            return getName();
        }
    }

    public String getMore() {
        try {
            String answer = sc.next();
            validation.checkGetMoreInput(answer);
            return answer;
        } catch (WrongInputException e) {
            return getMore();
        }
    }
}

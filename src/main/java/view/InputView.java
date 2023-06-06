package view;

import java.util.Scanner;

public class InputView {

    private Scanner sc = new Scanner(System.in);

    public String[] getName() {
        try {
            String name = sc.nextLine();
            return name.split(",");
        } catch (RuntimeException e) {
            return getName();
        }
    }
}

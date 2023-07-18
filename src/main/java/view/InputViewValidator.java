package view;

import util.StringValidator;

public class InputViewValidator {

    public static void validateString(final String input) {
        StringValidator.validation(input);
    }

    public static int validateStringToInt(final String input) throws NumberFormatException {
        return Integer.parseInt(input);
    }
}

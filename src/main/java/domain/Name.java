package domain;

import util.StringValidator;

public class Name {
    private final String name;

    public Name(final String name) {
        StringValidator.validation(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

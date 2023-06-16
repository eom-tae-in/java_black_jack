package domain;

public class Answer {

    private final String answer;
    private static final String YES = "y";

    public Answer(final String answer) {
        this.answer = answer;
    }

    public static boolean isYes(String answer) {
        return answer.equals(YES);
    }

    public String getAnswer() {
        return answer;
    }
}

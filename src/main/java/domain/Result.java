package domain;

public enum Result {
    WIN("승"),
    DRAW("무"),
    LOSE("패"),
    NONE("없음");

    private final String result;

    Result(final String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}

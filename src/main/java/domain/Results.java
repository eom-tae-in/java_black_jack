package domain;

import java.util.ArrayList;
import java.util.List;
import static domain.Result.DRAW;
import static domain.Result.LOSE;
import static domain.Result.WIN;

public class Results {

    private final List<Result> results;

    public Results() {
        this.results = new ArrayList<>();
    }

    public void addResult(final Result result) {
        results.add(result);
    }

    public int getWin() {
        return (int) results.stream()
                .filter(result -> result.getResult().equals(WIN.getResult()))
                .count();
    }
    public int getDraw() {
        return (int) results.stream()
                .filter(result -> result.getResult().equals(DRAW.getResult()))
                .count();
    }
    public int getLose() {
        return (int) results.stream()
                .filter(result -> result.getResult().equals(LOSE.getResult()))
                .count();
    }
}

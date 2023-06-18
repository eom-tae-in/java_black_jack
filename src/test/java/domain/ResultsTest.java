package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {

    private Results results;

    @BeforeEach
    void initData() {
        results = new Results();
    }

    @ParameterizedTest
    @DisplayName("게임의 결과를 저장하고 결과 이긴횟수를 반환한다.")
    @MethodSource("resultProvider")
    void check_add_result_and_check_return_count(final Result result, final int expectedWin,
                                                 final int expectedDraw, final int expectedLose) {
        //when
        results.addResult(result);
        //then
        assertThat(results.getWin()).isEqualTo(expectedWin);
        assertThat(results.getDraw()).isEqualTo(expectedDraw);
        assertThat(results.getLose()).isEqualTo(expectedLose);
    }

    static Stream<Arguments> resultProvider() {
        return Stream.of(
                Arguments.of(Result.WIN, 1, 0, 0),
                Arguments.of(Result.DRAW, 0, 1, 0),
                Arguments.of(Result.LOSE, 0, 0, 1)
        );
    }
}

package domain;

import dto.RefereeResultResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    private Referee referee;

    @BeforeEach
    void initData() {
        referee = new Referee();
    }

    @ParameterizedTest
    @DisplayName("심판이 딜러와 플레이어의 숫자를 보고 결과를 도출한다.")
    @MethodSource("cardSumAndResultProfitProvider")
    void dealer_win_player_lose(int dealerSum, int playerSum, ProfitRate expectedDealer, ProfitRate expectedPlayer) {
        //when
        RefereeResultResponse result = referee.decideResult(dealerSum, playerSum);

        //then
        assertThat(result.getPlayerResult()).isEqualTo(expectedPlayer);
        assertThat(result.getDealerResult()).isEqualTo(expectedDealer);
    }

    private static Stream<Arguments> cardSumAndResultProfitProvider() {
        return Stream.of(
                Arguments.of(21, 20, ProfitRate.BLACK_JACK, ProfitRate.LOSE)
                , Arguments.of(21, 21, ProfitRate.BOTH_BLACK_JACK, ProfitRate.BOTH_BLACK_JACK)
                , Arguments.of(17, 14, ProfitRate.WIN, ProfitRate.LOSE)
                , Arguments.of(16, 16, ProfitRate.DRAW, ProfitRate.DRAW)
                , Arguments.of(14, 17, ProfitRate.LOSE, ProfitRate.WIN)
                , Arguments.of(20, 21, ProfitRate.LOSE, ProfitRate.BLACK_JACK)
                , Arguments.of(26, 24, ProfitRate.LOSE, ProfitRate.WIN)
                , Arguments.of(26, 28, ProfitRate.LOSE, ProfitRate.WIN)
                , Arguments.of(26, 19, ProfitRate.LOSE, ProfitRate.WIN)
                , Arguments.of(19, 25, ProfitRate.WIN, ProfitRate.LOSE)
        );
    }
}

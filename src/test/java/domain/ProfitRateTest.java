package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRateTest {

    @ParameterizedTest
    @DisplayName("수익률과 배팅금액을 곲하여 수익을 계산하여 반환한다.")
    @MethodSource("battingAmountAndProfitProvider")
    void calculate_profit(int battingAmount, ProfitRate profitRate, int expected) {
        //when
        int profit = profitRate.multiply(battingAmount);

        //then
        assertThat(profit).isEqualTo(expected);
    }

    private static Stream<Arguments> battingAmountAndProfitProvider() {
        return Stream.of(
                Arguments.of(10000, ProfitRate.BLACK_JACK, 15000)
                , Arguments.of(10000, ProfitRate.BOTH_BLACK_JACK, 10000)
                , Arguments.of(10000, ProfitRate.WIN, 10000)
                , Arguments.of(10000, ProfitRate.DRAW, 0)
                , Arguments.of(10000, ProfitRate.LOSE, -10000));
    }
}

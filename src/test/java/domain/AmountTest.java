package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class AmountTest {

    private Amount amount;

    @BeforeEach
    void initData() {
        amount = new Amount();
    }

    @ParameterizedTest
    @DisplayName("손익을 계산하여 금액을 변경하고 금액을 반환한다.")
    @MethodSource("profitRateAndBattingAmountProvider")
    void add_profit_or_loss_and_return_amount(ProfitRate profitRate, int battingAmount, int expected) {
        //when
        amount.addProfitOrLoss(profitRate, battingAmount);
        int money = amount.getAmount();

        //then
        assertThat(money).isEqualTo(expected);
    }

    private static Stream<Arguments> profitRateAndBattingAmountProvider() {
        return Stream.of(
                Arguments.of(ProfitRate.WIN, 10000, 10000)
                , Arguments.of(ProfitRate.DRAW, 10000, 0)
                , Arguments.of(ProfitRate.LOSE, 10000, -10000)
                , Arguments.of(ProfitRate.BLACK_JACK, 10000, 15000)
                , Arguments.of(ProfitRate.BOTH_BLACK_JACK, 10000, 10000)
        );
    }
}

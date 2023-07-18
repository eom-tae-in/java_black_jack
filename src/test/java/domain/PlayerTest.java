package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void initData() {
        player = new Player(new Name("test"), new Deck(), new Money());
    }

    @Test
    @DisplayName("플레이어가 배팅 금액을 설정할 수 있고 플레이어의 배팅 금액을 반환할 수 있다.")
    void check_set_money_and_return_money() {
        //given
        int battingMoney = 10000;

        //when
        player.setMoney(battingMoney);
        int money = player.getMoney();

        //then
        assertThat(money).isEqualTo(battingMoney);
    }

    @ParameterizedTest
    @DisplayName("플레이어의 게임 결과에 따른 순익을 money 필드에 저장하고 반환할 수 있다.")
    @MethodSource("battingAmountAndProfitProvider")
    void check_set_profit_and_return_money(ProfitRate profitRate, int battingAmount, int expected) {
        //given
        player.setMoney(battingAmount);

        //when
        player.calculateProfitOrLoss(profitRate);

        //then
        int money = player.getMoney();
        assertThat(money).isEqualTo(expected);
    }

    private static Stream<Arguments> battingAmountAndProfitProvider() {
        return Stream.of(
                Arguments.of(ProfitRate.BLACK_JACK, 10000, 15000),
                Arguments.of(ProfitRate.BOTH_BLACK_JACK, 10000, 10000),
                Arguments.of(ProfitRate.WIN, 10000, 10000),
                Arguments.of(ProfitRate.DRAW, 10000, 0),
                Arguments.of(ProfitRate.LOSE, 10000, -10000)
        );
    }
}

package domain;

import dto.RefereeResultResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    private Referee referee;

    @BeforeEach
    void initData() {
        referee = new Referee();
    }

    @ParameterizedTest
    @DisplayName("심판이 딜러와 플레이어의 숫자를 보고 각자에게 승(WIN), 무(DRAW), 패(LOSE)를 반환한다.")
    @CsvSource(value = {"21,16,WIN,LOSE", "17,17,DRAW,DRAW", "16,21,LOSE,WIN"})
    void dealer_win_player_lose(int dealerSum, int playerSum, Result expectedDealerResult, Result expectedPlayerResult) {
        //when
        RefereeResultResponseDto result = referee.decideResult(dealerSum, playerSum);

        //then
        assertThat(result.getDealerResult()).isEqualTo(expectedDealerResult);
        assertThat(result.getPlayerResult()).isEqualTo(expectedPlayerResult);
    }
}

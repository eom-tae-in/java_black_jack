package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void initData() {
        player = new Player(new Name("test"), new ParticipantDeck());
    }

    @ParameterizedTest
    @DisplayName("플레이어의 게임 결과를 저장하고 저장한 결과를 반환한다.")
    @CsvSource(value = {"WIN, 승","DRAW, 무", "LOSE, 패"})
    void check_set_result_and_check_get_result(Result result, String expected) {
        //when
        player.addResult(result);
        String answer = player.getResult();
        //then
        assertThat(answer).isEqualTo(expected);
    }
}

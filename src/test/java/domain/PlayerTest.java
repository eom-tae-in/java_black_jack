package domain;

import dto.ResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void initData() {
        player = new Player(new Name("test"), new ResultDto(0, 0, 0), new ParticipantDeck());
    }

    @Test
    @DisplayName("플레이어가 입력한 결과를 Player 필드인 answer에 넣는 기능을 하는 setter와 이를 반환하는 getter를 검증한다.")
    void setAnswerTest() {
        //when
        player.setAnswer(new Answer("test"));
        String answer = player.getAnswer();

        //then
        assertThat(answer).isEqualTo("test");
    }
}

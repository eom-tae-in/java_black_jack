package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    private Players players;

    @BeforeEach
    void initData() {
        players = new Players(new ArrayList<>());
    }

    @Test
    @DisplayName("player를 list에 더하는 메서드 테스트")
    void check_add_player() {
        //when
        players.add(new Player(new Name("test"), new ParticipantDeck()));

        //then
        assertThat(players.getPlayers().size()).isEqualTo(1);
        assertThat(players.getPlayers().get(0).getName()).isEqualTo("test");
        assertThat(players.getPlayers().get(0).getDeck().size()).isEqualTo(0);
        assertThat(players.getPlayers().get(0).getSum()).isEqualTo(0);
    }

    @Test
    @DisplayName("게임에 참여한 플레이어들을 반환한다.")
    void check_return_players() {
        //given
        players.add(new Player(new Name("test1"), new ParticipantDeck()));
        players.add(new Player(new Name("test2"), new ParticipantDeck()));
        players.add(new Player(new Name("test3"), new ParticipantDeck()));

        //when
        List<Player> playerList = players.getPlayers();

        //then
        assertThat(playerList.size()).isEqualTo(3);
    }
}

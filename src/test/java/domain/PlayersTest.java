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
    @DisplayName("게임에 참여하는 플레이어들을 추가하고 추가한 플레이어들을 반환한다.")
    void check_add_player_and_return_players() {
        //given
        players.add(createPlayer("test1"));
        players.add(createPlayer("test2"));
        players.add(createPlayer("test3"));

        //when
        List<Player> playerList = players.getPlayers();

        //then
        assertThat(playerList.size()).isEqualTo(3);
        assertThat(playerList.get(0).getName()).isEqualTo("test1");
        assertThat(playerList.get(1).getName()).isEqualTo("test2");
        assertThat(playerList.get(2).getName()).isEqualTo("test3");
    }

    private Player createPlayer(String name) {
        return new Player(new Name(name), new Deck(), new Money());
    }
}

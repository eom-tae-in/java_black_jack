//package domain;
//
//import dto.RefereeResultResponseDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import java.util.ArrayList;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class PlayersTest {
//
//    private Players players;
//
//    @BeforeEach
//    void initData() {
//        players = new Players(new ArrayList<>());
//    }
//
//    @Test
//    @DisplayName("매개변수로 들어온 Player를 플레이어 리스트에 더하는 메서드 테스트")
//    void addTest() {
//        //when
//        players.add(new Player(new Name("test"), new RefereeResultResponseDto(1, 2, 3), new ParticipantDeck()));
//
//        //then
//        assertThat(players.getPlayers().size()).isEqualTo(1);
//        assertThat(players.getPlayers().get(0).getName()).isEqualTo("test");
//        assertThat(players.getPlayers().get(0).getDeck().size()).isEqualTo(0);
//        assertThat(players.getPlayers().get(0).getSum()).isEqualTo(0);
//        assertThat(players.getPlayers().get(0).getWin()).isEqualTo(1);
//        assertThat(players.getPlayers().get(0).getDrew()).isEqualTo(2);
//        assertThat(players.getPlayers().get(0).getLose()).isEqualTo(3);
//    }
//}

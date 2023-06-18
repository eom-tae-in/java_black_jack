//package domain;
//
//import dto.RefereeResultResponseDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import java.util.List;
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class ParticipantTest {
//
//    private Participant participant;
//
//    @BeforeEach
//    void initData() {
//        participant = new Participant(new Name("test"), new RefereeResultResponseDto(0, 0, 0), new ParticipantDeck());
//    }
//
//    @Test
//    @DisplayName("카드를 한장 받는 메서드 테스트")
//    void drawCardTest() {
//        //when
//        participant.drawCard(new Card(new Shape("스페이드"), new Value("10", 10)));
//
//        //then
//        assertThat(participant.getDeck().size()).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("Participant의 이름을 문자열로 반환하는 메서드 테스트")
//    void getNameTest() {
//        //when
//        String name = participant.getName();
//
//        //then
//        assertThat(name).isEqualTo("test");
//    }
//
//    @Test
//    @DisplayName("Participant의 카드들의 총 합을 반환하는 메서드 테스트")
//    void getSumTest() {
//        //given
//        participant.drawCard(new Card(new Shape("하트"), new Value("5", 5)));
//        participant.drawCard(new Card(new Shape("클로버"), new Value("6", 6)));
//
//        //when
//        int sum = participant.getSum();
//
//        //then
//        assertThat(sum).isEqualTo(11);
//    }
//
//    @Test
//    @DisplayName("Participant의 승리 횟수를 반환하는 메서드 테스트")
//    void getWinTest() {
//        //given
//        participant = new Participant(new Name("test"), new RefereeResultResponseDto(1, 0, 0), new ParticipantDeck());
//
//        //when
//        int win = participant.getWin();
//
//        //then
//        assertThat(win).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("Participant의 비긴 횟수를 반환하는 메서드 테스트")
//    void getDrewTest() {
//        //given
//        participant = new Participant(new Name("test"), new RefereeResultResponseDto(1, 2, 0), new ParticipantDeck());
//
//        //when
//        int drew = participant.getDrew();
//
//        //then
//        assertThat(drew).isEqualTo(2);
//    }
//
//    @Test
//    @DisplayName("Participant의 패배 횟수를 반환하는 메서드 테스트")
//    void getLoseTest() {
//        //given
//        participant = new Participant(new Name("test"), new RefereeResultResponseDto(1, 2, 3), new ParticipantDeck());
//
//        //when
//        int lose = participant.getLose();
//
//        //then
//        assertThat(lose).isEqualTo(3);
//    }
//
//    @Test
//    @DisplayName("Participant가 이겼을 경우 승리 횟수를 증가시키는 메서드 테스트")
//    void winTest() {
//        //when
//        participant.win();
//
//        //then
//        assertThat(participant.getWin()).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("Participant가 비겼을 경우 비긴 횟수를 증가시키는 메서드 테스트")
//    void drewTest() {
//        //when
//        participant.drew();
//
//        //then
//        assertThat(participant.getDrew()).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("Participant가 진 경우 패배 횟수를 증가시키는 메서드 테스트")
//    void loseTest() {
//        //when
//        participant.lose();
//
//        //then
//        assertThat(participant.getLose()).isEqualTo(1);
//    }
//
//    @Test
//    @DisplayName("Participant의 카드 덱을 반환하는 메서드 테스트")
//    void getDeckTest() {
//        //given
//        participant.drawCard(new Card(new Shape("하트"), new Value("3", 3)));
//        participant.drawCard(new Card(new Shape("클로버"), new Value("7", 7)));
//
//        //when
//        List<Card> deck = participant.getDeck();
//
//        //then
//        assertThat(deck.size()).isEqualTo(2);
//        assertThat(deck.get(0).getNumber()).isEqualTo(3);
//        assertThat(deck.get(0).getValue()).isEqualTo("3");
//        assertThat(deck.get(0).getValueAndShape()).isEqualTo("3하트");
//        assertThat(deck.get(1).getNumber()).isEqualTo(7);
//        assertThat(deck.get(1).getValue()).isEqualTo("7");
//        assertThat(deck.get(1).getValueAndShape()).isEqualTo("7클로버");
//    }
//}

package domain;

import exception.NotFoundAceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ParticipantDeckTest {

    private ParticipantDeck participantDeck;

    @BeforeEach
    void initData() {
        participantDeck = new ParticipantDeck();
    }

    @Test
    @DisplayName("Participant가 카드를 받으면 카드 덱에 받은 카드가 저장시키는 메서드 테스트")
    void addTest() {
        //when
        participantDeck.add(new Card(new Shape("스페이드"), new Value("K", 10)));

        //then
        assertThat(participantDeck.getCards().size()).isEqualTo(1);
        assertThat(participantDeck.getCards().get(0).getNumber()).isEqualTo(10);
        assertThat(participantDeck.getCards().get(0).getValue()).isEqualTo("K");
        assertThat(participantDeck.getCards().get(0).getValueAndShape()).isEqualTo("K스페이드");
    }

    @Test
    @DisplayName("Participant가 뽑은 카드들의 합을 계산하여 반환하는 메서드 테스트")
    void calculateSumTest() {
        //given
        participantDeck.add(new Card(new Shape("스페이드"), new Value("K", 10)));
        participantDeck.add(new Card(new Shape("하트"), new Value("Q", 10)));
        participantDeck.add(new Card(new Shape("다이아몬드"), new Value("J", 10)));

        //when
        int sum = participantDeck.calculateSum();

        //then
        assertThat(sum).isEqualTo(30);
    }

    @Test
    @DisplayName("Participant의 카드 덱에 Ace가 존재하면 아무런 예외도 발생하지 않는다.")
    void findAceTest_Success() {
        //given
        participantDeck.add(new Card(new Shape("클로버"), new Value("7", 7)));
        participantDeck.add(new Card(new Shape("하트"), new Value("A", 1)));

        //when //then
        assertThatCode(() -> participantDeck.findAce()).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Participant의 카드 덱에 Ace가 존재하지 않으면 예외가 발생한다.")
    void findAceTest_Failure_NotFoundAceCException() {
        //given
        participantDeck.add(new Card(new Shape("다이아몬드"), new Value("7", 7)));
        participantDeck.add(new Card(new Shape("하트"), new Value("Q", 10)));

        //when //then
        assertThatThrownBy(() -> participantDeck.findAce()).isInstanceOf(NotFoundAceException.class);
    }

    @Test
    @DisplayName("카드 덱에 Ace가 있는 경우 작은 값(1)과 큰 값(11)의 경우를 모두 계산하여 합이 21을 넘지 않는 더 큰 값을 반환한다.(작은 값)")
    void calculateMaxTest_SmallNumber() {
        //given
        participantDeck.add(new Card(new Shape("하트"), new Value("Q", 10)));
        participantDeck.add(new Card(new Shape("클로버"), new Value("7", 7)));
        participantDeck.add(new Card(new Shape("다이아몬드"), new Value("A", 1)));
        int sum = participantDeck.calculateSum();

        //when
        int calculateMaxSum = participantDeck.calculateMax(sum);

        //then
        assertThat(calculateMaxSum).isEqualTo(sum);
        assertThat(calculateMaxSum).isEqualTo(18);
    }

    @Test
    @DisplayName("카드 덱에 Ace가 있는 경우 작은 값(1)과 큰 값(11)의 경우를 모두 계산하여 합이 21을 넘지 않는 더 큰 값을 반환한다.(큰 값)")
    void calculateMaxTest_LargeNumber() {
        //given
        participantDeck.add(new Card(new Shape("하트"), new Value("Q", 10)));
        participantDeck.add(new Card(new Shape("다이아몬드"), new Value("A", 1)));
        int sum = participantDeck.calculateSum();

        //when
        int calculateMax = participantDeck.calculateMax(sum);

        //then
        assertThat(calculateMax).isEqualTo(21);
        assertThat(calculateMax).isNotEqualTo(sum);
    }

    @Test
    @DisplayName("Participant의 카드 덱의 최대 값을 반환하는 메서드 테스트 ")
    void SumUserDeck() {
        //given
        participantDeck.add(new Card(new Shape("스페이드"), new Value("A", 1)));
        participantDeck.add(new Card(new Shape("다이아몬드"), new Value("2", 2)));
        participantDeck.add(new Card(new Shape("다이아몬드"), new Value("7", 7)));

        //when
        int sum = participantDeck.sum();

        //then
        assertThat(sum).isEqualTo(20);
    }
}

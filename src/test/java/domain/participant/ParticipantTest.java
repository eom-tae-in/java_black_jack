package domain.participant;

import domain.Card;
import domain.Name;
import domain.Participant;
import domain.ParticipantDeck;
import domain.Shape;
import domain.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    private Participant participant;

    @BeforeEach
    void initData() {
        participant = new ConcreteParticipant(new Name("test"), new ParticipantDeck());
    }

    @Test
    @DisplayName("카드를 한 장 받아 participant 카드 덱에 더한다.")
    void add_one_card_to_participant_deck() {
        //when
        participant.getCard(new Card(new Shape("스페이드"), new Value("10", 10)));

        //then
        assertThat(participant.getDeck().size()).isEqualTo(1);
        assertThat(participant.getDeck().get(0).getNumber()).isEqualTo(10);
        assertThat(participant.getDeck().get(0).getValue()).isEqualTo("10");
        assertThat(participant.getDeck().get(0).getValueAndShape()).isEqualTo("10스페이드");
    }

    @Test
    @DisplayName("participant의 이름을 문자열로 반환하는 메서드 테스트")
    void check_return_participant_name() {
        //when
        String name = participant.getName();

        //then
        assertThat(name).isEqualTo("test");
    }

    @Test
    @DisplayName("participant의 카드들의 총 합을 반환하는 메서드 테스트")
    void check_return_participant_card_sum() {
        //given
        participant.getCard(new Card(new Shape("하트"), new Value("5", 5)));
        participant.getCard(new Card(new Shape("클로버"), new Value("6", 6)));

        //when
        int sum = participant.getSum();

        //then
        assertThat(sum).isEqualTo(11);
    }

    @Test
    @DisplayName("participant의 카드 덱을 반환하는 메서드 테스트")
    void check_return_participant_card_deck() {
        //given
        participant.getCard(new Card(new Shape("하트"), new Value("3", 3)));
        participant.getCard(new Card(new Shape("클로버"), new Value("7", 7)));

        //when
        List<Card> deck = participant.getDeck();

        //then
        assertThat(deck.size()).isEqualTo(2);
        assertThat(deck.get(0).getNumber()).isEqualTo(3);
        assertThat(deck.get(0).getValue()).isEqualTo("3");
        assertThat(deck.get(0).getValueAndShape()).isEqualTo("3하트");
        assertThat(deck.get(1).getNumber()).isEqualTo(7);
        assertThat(deck.get(1).getValue()).isEqualTo("7");
        assertThat(deck.get(1).getValueAndShape()).isEqualTo("7클로버");
    }

    @Test
    @DisplayName("participant의 카드 합이 21초과이면 true를 반환한다.")
    void check_participant_card_sum_above_twenty_one_return_true() {
        //given
        participant.getCard(new Card(new Shape("하트"), new Value("J", 10)));
        participant.getCard(new Card(new Shape("하트"), new Value("Q", 10)));
        participant.getCard(new Card(new Shape("하트"), new Value("K", 10)));

        //when
        boolean result = participant.isGameOver();

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("participant의 카드 합이 21이하이면 false를 반환한다.")
    void check_participant_card_sum_twenty_one_or_less_return_false() {
        //given
        participant.getCard(new Card(new Shape("하트"), new Value("J", 10)));
        participant.getCard(new Card(new Shape("하트"), new Value("Q", 10)));

        //when
        boolean result = participant.isGameOver();

        //then
        assertThat(result).isFalse();
    }
}

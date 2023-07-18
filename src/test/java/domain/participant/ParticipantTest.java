package domain.participant;

import domain.Card;
import domain.Name;
import domain.Participant;
import domain.Deck;
import domain.Shape;
import domain.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ParticipantTest {

    private Participant participant;

    @BeforeEach
    void initData() {
        participant = new ConcreteParticipant(new Name("test"), new Deck());
    }

    @Test
    @DisplayName("카드를 한 장 받아 participant 카드 덱에 더한다.")
    void add_one_card_to_participant_deck() {
        //when
        participant.receiveCard(new Card(new Shape("스페이드"), new Value("10", 10)));

        //then
        assertThat(participant.getDeck().size()).isEqualTo(1);
        assertThat(participant.getDeck().get(0).getNumber()).isEqualTo(10);
        assertThat(participant.getDeck().get(0).getValue()).isEqualTo("10");
        assertThat(participant.getDeck().get(0).getValueAndShape()).isEqualTo("10스페이드");
    }

    @Test
    @DisplayName("참가자의 이름을 문자열로 반환하는 메서드 테스트")
    void check_return_participant_name() {
        //when
        String name = participant.getName();

        //then
        assertThat(name).isEqualTo("test");
    }

    @Test
    @DisplayName("참가자의 카드들의 총 합을 반환하는 메서드 테스트")
    void check_return_participant_card_sum() {
        //given
        participant.receiveCard(new Card(new Shape("하트"), new Value("5", 5)));
        participant.receiveCard(new Card(new Shape("클로버"), new Value("6", 6)));

        //when
        int sum = participant.getSum();

        //then
        assertThat(sum).isEqualTo(11);
    }

    @Test
    @DisplayName("참가자의 카드 덱을 반환하는 메서드 테스트")
    void check_return_participant_card_deck() {
        //given
        participant.receiveCard(new Card(new Shape("하트"), new Value("3", 3)));
        participant.receiveCard(new Card(new Shape("클로버"), new Value("7", 7)));

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

    @ParameterizedTest
    @DisplayName("참가자의 카드 합이 21이하이면 false, 21 초과이면 true를 반환한다.")
    @MethodSource("participantCardProvider")
    void above_twenty_one_return_true_if_not_return_false(List<Card> cards, boolean expected) {
        //given
        IntStream.range(0, cards.size()).forEach(i -> {
            participant.receiveCard(cards.get(i));
        });

        //when
        boolean result = participant.isGameOver();

        //then
        assertThat(result).isEqualTo(expected);
    }

    private static Stream<Arguments> participantCardProvider() {
        return Stream.of(
                Arguments.of(twentyOneOrLessCardDeck(), false)
                , Arguments.of(aboveTwentyOneCardDeck(), true));
    }

    private static List<Card> twentyOneOrLessCardDeck() {
        return List.of(new Card(new Shape("하트"), new Value("J", 10))
                , new Card(new Shape("하트"), new Value("Q", 10)));
    }

    private static List<Card> aboveTwentyOneCardDeck() {
        return List.of(new Card(new Shape("하트"), new Value("J", 10))
                , new Card(new Shape("하트"), new Value("Q", 10))
                , new Card(new Shape("하트"), new Value("K", 10)));
    }
}

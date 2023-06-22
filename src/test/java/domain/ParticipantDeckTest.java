package domain;

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

public class ParticipantDeckTest {

    private ParticipantDeck participantDeck;

    @BeforeEach
    void initData() {
        participantDeck = new ParticipantDeck();
    }

    @Test
    @DisplayName("참가자의 카드들을 반환한다.")
    void check_return_participant_cards() {
        //given
        participantDeck.add(new Card(new Shape("다이아몬드"), new Value("6", 6)));

        //when
        List<Card> cards = participantDeck.getCards();

        //then
        assertThat(cards.size()).isEqualTo(1);
        assertThat(cards.get(0).getNumber()).isEqualTo(6);
        assertThat(cards.get(0).getValue()).isEqualTo("6");
        assertThat(cards.get(0).getValueAndShape()).isEqualTo("6다이아몬드");
    }

    @Test
    @DisplayName("카드를 받으면 참가자의 카드 덱에 받은 카드가 저장된다.")
    void add_card_to_participant_deck() {
        //when
        participantDeck.add(new Card(new Shape("스페이드"), new Value("K", 10)));

        //then
        assertThat(participantDeck.getCards().size()).isEqualTo(1);
        assertThat(participantDeck.getCards().get(0).getNumber()).isEqualTo(10);
        assertThat(participantDeck.getCards().get(0).getValue()).isEqualTo("K");
        assertThat(participantDeck.getCards().get(0).getValueAndShape()).isEqualTo("K스페이드");
    }

    @ParameterizedTest
    @DisplayName("참가자의 카드들의 합을 계산한다. A가 존재하는 경우 A를 1, 11로 계산한 결과를 비교하여 21보다 작은 더 큰 값을 반환한다.")
    @MethodSource("participantDeckProvider")
    void calculate_sum_exclude_special_value(List<Card> cards, int expectedSum) {
        //given
        IntStream.range(0, cards.size()).forEach(i -> {
            participantDeck.add(cards.get(i));
        });

        //when
        int sum = participantDeck.sum();

        //then
        assertThat(sum).isEqualTo(expectedSum);
    }

    private static Stream<Arguments> participantDeckProvider() {
        return Stream.of(
                Arguments.of(calculateAceAsElevenDeck(), 16),
                Arguments.of(calculateAceAsOneDeck(), 21),
                Arguments.of(excludeAceDeck(), 13)
        );
    }

    private static List<Card> calculateAceAsElevenDeck() {
        return List.of(new Card(new Shape("하트"), new Value("A", 1)),
                new Card(new Shape("하트"), new Value("5", 5)));
    }

    private static List<Card> calculateAceAsOneDeck() {
        return List.of(new Card(new Shape("하트"), new Value("A", 1)),
                new Card(new Shape("하트"), new Value("J", 10)),
                new Card(new Shape("하트"), new Value("Q", 10)));
    }

    private static List<Card> excludeAceDeck() {
        return List.of(new Card(new Shape("하트"), new Value("6", 6)),
                new Card(new Shape("하트"), new Value("7", 7)));
    }
}

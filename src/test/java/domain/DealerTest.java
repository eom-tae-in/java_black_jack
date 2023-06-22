package domain;

import exception.CardDeckEmptyException;
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
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void initData() {
        dealer = new Dealer(new Name("딜러"), new ParticipantDeck(), new Results());
    }

    @ParameterizedTest
    @DisplayName("딜러의 카드 숫자 합이 16이하면 true를 반환하고 16 초과이면 false를 반환한다.")
    @MethodSource("getMoreCardProvider")
    void check_card_sum_sixteen_or_less_return_true(List<Card> cards, boolean expected) {
        //given
        IntStream.range(0, cards.size()).forEach(i -> {
            dealer.getCard(cards.get(i));
        });

        //when
        boolean result = dealer.canGetMoreCard();

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("딜러의 카드 중 가장 먼저 뽑은 한 장의 카드만 반환한다.")
    void check_return_first_card() {
        //given
        dealer.getCard(new Card(new Shape("다이아몬드"), new Value("4", 4)));
        dealer.getCard(new Card(new Shape("하트"), new Value("9", 9)));

        //when
        Card card = dealer.getFirstCard();

        //then
        assertThat(card.getNumber()).isEqualTo(4);
        assertThat(card.getValue()).isEqualTo("4");
        assertThat(card.getValueAndShape()).isEqualTo("4다이아몬드");
    }

    @Test
    @DisplayName("딜러가 가장 먼저 뽑은 카드를 반환할 때 딜러가 카드가 없으면 예외가 발생한다.")
    void get_first_card_but_no_card_throw_exception() {
        //when //then
        assertThatThrownBy(() -> dealer.getFirstCard())
                .isInstanceOf(CardDeckEmptyException.class);
    }

    @ParameterizedTest
    @DisplayName("딜러의 게임 결과를 저장하고 저장한 결과를 반환한다.")
    @MethodSource("resultProvider")
    void check_add_game_result_and_check_get_game_result(Result result, String expected) {
        //when
        dealer.addResult(result);
        String answer = dealer.getResult();
        //then
        assertThat(answer).isEqualTo(expected);
    }

    private static Stream<Arguments> getMoreCardProvider() {
        return Stream.of(
                Arguments.of(sixteenOrLessCardDeck(), true),
                Arguments.of(aboveSixteenCardDeck(), false)
        );
    }

    private static List<Card> sixteenOrLessCardDeck() {
        return List.of(new Card(new Shape("하트"), new Value("7",7)),
                new Card(new Shape("하트"), new Value("5", 5)));
    }

    private static List<Card> aboveSixteenCardDeck() {
        return List.of(new Card(new Shape("하트"), new Value("J", 10)),
                new Card(new Shape("하트"), new Value("Q", 10)));
    }

    private static Stream<Arguments> resultProvider() {
        return Stream.of(
                Arguments.of(Result.WIN, "1승 "),
                Arguments.of(Result.DRAW, "1무 "),
                Arguments.of(Result.LOSE, "1패")
        );
    }
}

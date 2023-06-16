package domain;

import exception.EmptyCardDeckException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Set;
import java.util.Queue;
import java.util.HashSet;
import java.util.stream.IntStream;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class CardDeckTest {

    private static final int TOTAL_CARD_NUMBER = 52;

    private CardDeck cardDeck;

    @BeforeEach
    void initData() {
        cardDeck = CardDeck.create();
    }

    @Test
    @DisplayName("블랙잭 게임을 시작하면 카드덱에 52장의 카드들이 생성된다.")
    void createFiftyTwoCardsTest() {
        //then
        assertThat(cardDeck.getCardDeck().size()).isEqualTo(TOTAL_CARD_NUMBER);
    }

    @Test
    @DisplayName("생성된 52장의 카드는 모두 다른 카드이다")
    void createDifferentCardsTest() {
        //given //when
        Set<String> cards = new HashSet<>();
        Queue<Card> deck = cardDeck.getCardDeck();
        while (!deck.isEmpty()) {
            cards.add(deck.poll().getValueAndShape());
        }

        //then
        assertThat(cards.size()).isEqualTo(TOTAL_CARD_NUMBER);
    }

    @Test
    @DisplayName("생성된 52장의 카드덱에서 카드를 성공적으로 뽑으면 Card가 반환된다.")
    void drawTest_Success() {
        //given
        Card card = cardDeck.getCardDeck().peek();

        //when
        Card drawnCard = cardDeck.draw();

        //then
        assertThat(drawnCard).isEqualTo(card);
    }

    @Test
    @DisplayName("카드를 뽑으면 카드덱의 총 카드 수가 줄어든다")
    void drawTest_Success_DecreaseTotalCardNumber() {
        //when
        cardDeck.draw();

        //then
        assertThat(cardDeck.getCardDeck().size()).isEqualTo(TOTAL_CARD_NUMBER - 1);
        assertThat(cardDeck.getCardDeck().size()).isNotEqualTo(TOTAL_CARD_NUMBER);
    }

    @Test
    @DisplayName("더 이상 뽑을 카드가 없는 경우 더 이상 뽑을 카드가 없다는 문구와 함께 예외를 발생시킨다.")
    void drawTEst_Failure_EmptyCardDeckException() {
        //given
        IntStream.range(0, TOTAL_CARD_NUMBER).forEach(i -> {
            cardDeck.draw();
        });

        //when //then
        assertThatThrownBy(() -> cardDeck.draw())
                .isInstanceOf(EmptyCardDeckException.class);
    }
}

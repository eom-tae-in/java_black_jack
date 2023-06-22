package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CardDeckTest {

    private static final int TOTAL_CARD_NUMBER = 52;

    private CardDeck cardDeck;

    @BeforeEach
    void initData() {
        cardDeck = CardDeck.create();
    }

    //리플랙션

    @Test
    @DisplayName("더 이상 뽑을 카드가 없는 경우 더 이상 뽑을 카드가 없다는 문구와 함께 예외를 발생시킨다.")
    void draw_failure_empty_card_deck_exception() {
        //given
        IntStream.range(0, TOTAL_CARD_NUMBER).forEach(i -> {
            cardDeck.draw();
        });

        //when //then
        assertThatThrownBy(() -> cardDeck.draw())
                .isInstanceOf(RuntimeException.class);
    }
}

package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CardDeckTest {

    @Test
    @DisplayName("블랙잭게임을 시작하면 카드덱에 52장의 서로 다른 카드들이 생성된다.")
    void CreateCardDeck() {
        //given
        CardDeck cardDeck = new CardDeck();

        //when
        cardDeck.generate();

        //then
        assertThat(cardDeck.getCardDeck().size()).isEqualTo(52);
    }
}

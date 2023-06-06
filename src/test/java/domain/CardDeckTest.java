package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardDeckTest {

    @Test
    @DisplayName("블랙잭게임을 시작하면 카드덱에 52장의 서로 다른 카드들이 생성된다.")
    void CreateCardDeck() {
        //given
        CardDeck cardDeck = new CardDeck();

        //when
        ArrayList<Card> cards = cardDeck.generate();

        //then
        assertThat(cards.size()).isEqualTo(52);
    }

    @Test
    @DisplayName("카드덱에서 처음 카드를 뽑을 경우 카드가 2장 뽑히게 된다.")
    void DrawCardFirst() {
        //given
        CardDeck cardDeck = new CardDeck();
        cardDeck.ready();

        //when
        DrawCardDto drawCardDto = cardDeck.drawFirst();

        //then
        assertThat(drawCardDto.getFirst()).isNotNull();
        assertThat(drawCardDto.getSecond()).isNotNull();
    }

    @Test
    @DisplayName("카드덱에서 카드를 추가로 뽑을 때 카드가 1장 뽑히게 된다.")
    void DrawCard() {
        //given
        CardDeck cardDeck = new CardDeck();
        cardDeck.ready();

        //when
        DrawCardDto drawCardDto = cardDeck.draw();

        //then
        assertThat(drawCardDto.getFirst()).isNotNull();
        assertThat(drawCardDto.getSecond()).isNull();
    }
}

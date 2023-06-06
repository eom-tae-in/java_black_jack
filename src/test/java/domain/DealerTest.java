package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    @Test
    @DisplayName("딜러의 카드들의 숫자 합이 16이하면 한 장을 더 받는다.")
    void DrawMoreCard() {
        //given
        CardDeck cardDeck = new CardDeck();
        cardDeck.ready();
        UserDeck userDeck = new UserDeck();
        Dealer dealer = new Dealer(new Participant(new Name("apple"), userDeck, cardDeck));
        userDeck.add(new DrawCardDto(new Card(new Shape("하트"), new Value("6", 6))));
        userDeck.add(new DrawCardDto(new Card(new Shape("클로버"), new Value("7", 7))));

        //when
        dealer.drawCard();

        //then
        assertThat(userDeck.getCards().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("딜러의 숫자의 합이 21이 넘는 경우 게임에서 지게 된다.")
    void GameOver() {
        //given
        CardDeck cardDeck = new CardDeck();
        cardDeck.ready();
        UserDeck userDeck = new UserDeck();
        userDeck.add(new DrawCardDto(new Card(new Shape("다이아몬드"), new Value("J",10))));
        userDeck.add(new DrawCardDto(new Card(new Shape("다이아몬드"), new Value("Q",10))));
        userDeck.add(new DrawCardDto(new Card(new Shape("다이아몬드"), new Value("K",10))));
        Dealer dealer = new Dealer(new Participant(new Name("apple"), userDeck, cardDeck));

        //when
        boolean result = dealer.isGameOver();

        //then
        assertThat(result).isTrue();
    }
}

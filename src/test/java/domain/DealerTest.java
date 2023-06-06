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
        UserDeck userDeck = new UserDeck();
        Dealer dealer = new Dealer(new Participant(new Name("apple"), userDeck, cardDeck));
        userDeck.add(new DrawCardDto(new Card(new Shape("하트"), new Value("6", 6))));
        userDeck.add(new DrawCardDto(new Card(new Shape("클로버"), new Value("7", 7))));

        //when
        dealer.drawCard();

        //then
        assertThat(userDeck.getCards().size()).isEqualTo(3);
    }
}

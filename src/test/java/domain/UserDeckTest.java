package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDeckTest {

    @Test
    @DisplayName("유저가 카드를 뽑았을 경우 유저 덱에 카드가 저장되어야 한다.")
    void AddUserDeck() {
        //given
        UserDeck userDeck = new UserDeck();
        DrawCardDto drawCardDto = new DrawCardDto(new Card(new Shape("스페이드"), new Value(4)));

        //when
        userDeck.add(drawCardDto);

        //then
        assertThat(userDeck.getCards().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("유저가 뽑은 카드들의 숫자를 더하여 반환한다.")
    void SumUserDeck() {
        //given
        UserDeck userDeck = new UserDeck();
        userDeck.add(new DrawCardDto(new Card(new Shape("스페이드"), new Value(7))));
        userDeck.add(new DrawCardDto(new Card(new Shape("하트"), new Value(8))));
        userDeck.add(new DrawCardDto(new Card(new Shape("클로버"), new Value(3))));

        //when
        int sum = userDeck.sum();

        //then
        assertThat(sum).isEqualTo(18);
    }
}
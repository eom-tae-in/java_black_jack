package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test
    @DisplayName("플레이어가 카드를 한장 더 받기를 원할 경우 카드 한장을 더 받는다.")
    void DrawMoreCard() {
        //given
        UserDeck userDeck = new UserDeck();
        DrawCardDto drawCardDto = new DrawCardDto(new Card(new Shape("스페이드"), new Value(6)),
                new Card(new Shape("하트"), new Value(4)));
        Player player = new Player(new Name("apple"), userDeck);
        userDeck.add(drawCardDto);
        //when
        player.drawCard();

        //then
        assertThat(userDeck.getCards().size()).isEqualTo(3);
    }
}

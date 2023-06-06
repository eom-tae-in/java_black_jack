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
        CardDeck cardDeck = new CardDeck();
        cardDeck.ready();
        UserDeck userDeck = new UserDeck();
        DrawCardDto drawCardDto = new DrawCardDto(new Card(new Shape("스페이드"), new Value("6", 6)),
                new Card(new Shape("하트"), new Value("4", 4)));
        Player player = new Player(new Participant(new Name("apple"), userDeck, cardDeck));
        userDeck.add(drawCardDto);
        String answer = "y";

        //when
        player.drawCard(answer);

        //then
        assertThat(userDeck.getCards().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("플레이어의 숫자의 합이 21이 넘는 경우 게임에서 지게 된다.")
    void GameOver() {
        //given
        CardDeck cardDeck = new CardDeck();
        cardDeck.ready();
        UserDeck userDeck = new UserDeck();
        userDeck.add(new DrawCardDto(new Card(new Shape("하트"), new Value("J", 10))));
        userDeck.add(new DrawCardDto(new Card(new Shape("스페이드"), new Value("Q", 10))));
        userDeck.add(new DrawCardDto(new Card(new Shape("클로버"), new Value("K", 10))));
        Player player = new Player(new Participant(new Name("apple"), userDeck, cardDeck));

        //when
        boolean result = player.isGameOver();

        //then
        assertThat(result).isTrue();
    }
}

package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    private Card card;
    @BeforeEach
    void initData() {
       card = new Card(new Shape("다이아몬드"), new Value("J", 10));
    }

    @Test
    @DisplayName("카드의 값을 숫자를 반환하는 메서드 테스트")
    void check_return_card_number() {
        //when
        int number = card.getNumber();

        //then
        assertThat(number).isEqualTo(10);
        assertThat(number).isNotEqualTo(4);
    }

    @Test
    @DisplayName("카드의 값을 문자를 반환하는 메서드 테스트")
    void check_return_card_value() {
        //when
        String value = card.getValue();

        //then
        assertThat(value).isEqualTo("J");
        assertThat(value).isNotEqualTo("10");
    }

    @Test
    @DisplayName("카드의 값과 문양을 반환하는 메서드 테스트")
    void check_return_card_value_and_shape() {
        //when
        String cardName = card.getValueAndShape();

        //when
        assertThat(cardName).isEqualTo("J다이아몬드");
        assertThat(cardName).isNotEqualTo("J하트");
        assertThat(cardName).isNotEqualTo("4다이아몬드");
    }

    @Test
    @DisplayName("카드가 A가 맞으면 true를 반환한다.")
    void check_card_is_ace_return_true() {
        //given
        Card card = new Card(new Shape("하트"), new Value("A", 1));

        //when
        boolean result = card.isAce(card.getValue());

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("카드가 A가 아니면 false를 반환한다.")
    void check_card_is_not_ace_return_false() {
        //when
        boolean result = card.isAce(card.getValue());

        //then
        assertThat(result).isFalse();
    }
}

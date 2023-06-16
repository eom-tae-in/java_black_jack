package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    private Card card;
    @BeforeEach
    void initData() {
       card = new Card(new Shape("다이아몬드"), new Value("3", 3));
    }

    @Test
    @DisplayName("카드의 값을 숫자를 반환하는 메서드 테스트")
    void getNumberTest() {
        //when
        int number = card.getNumber();

        //then
        assertThat(number).isEqualTo(3);
        assertThat(number).isNotEqualTo(4);
    }

    @Test
    @DisplayName("카드의 값을 문자를 반환하는 메서드 테스트")
    void getValueTest() {
        //when
        String value = card.getValue();

        //then
        assertThat(value).isEqualTo("3");
        assertThat(value).isNotEqualTo("4");
    }

    @Test
    @DisplayName("카드의 값과 문양을 반환하는 메서드 테스트")
    void getValueAndShapeTest() {
        //when
        String cardName = card.getValueAndShape();

        //when
        assertThat(cardName).isEqualTo("3다이아몬드");
        assertThat(cardName).isNotEqualTo("3하트");
        assertThat(cardName).isNotEqualTo("4다이아몬드");
    }
}

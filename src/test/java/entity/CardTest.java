package entity;

import domain.Shape;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CardTest {

    @Test
    @DisplayName("Card 인스턴스를 생성할 때 shape와 value가 올바르게 들어왔을 경우 테스트가 성공한다.")
    void CardArgumentTest_Success() {
        //given
        Shape shape = new Shape("spade");
        Value value = new Value("ace");

        // when
        Card card = new Card(shape, value);

        //then
        Assertions.assertThat(card.getShape()).isEqualTo(shape);
        Assertions.assertThat(card.getValue()).isEqualTo(value);
    }
}
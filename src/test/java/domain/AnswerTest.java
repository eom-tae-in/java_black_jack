package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @Test
    @DisplayName("매개변수로 들어온 문자열이 y인 경우 true를 반환한다")
    void isYesTest_True() {
        //given
        String yes = "y";

        //when
        boolean result = Answer.isYes(yes);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("매개변수로 들어온 문자열이 y가 아닌 경우 false를 반환한다.")
    void isYesTest_False() {
        //given
        String no = "n";
        String str = "apple";

        //when
        boolean result1 = Answer.isYes(no);
        boolean result2 = Answer.isYes(str);

        //then
        assertThat(result1).isFalse();
        assertThat(result2).isFalse();
    }
}

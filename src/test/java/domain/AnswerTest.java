package domain;

import dto.InputBlankException;
import dto.InputEmptyException;
import org.assertj.core.api.WithThrowable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @Test
    @DisplayName("문자열이 y인 경우 true를 반환한다")
    void check_string_is_y_return_true() {
        //given
        String yes = "y";

        //when
        boolean result = Answer.isYes(yes);

        //then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("문자열이 y가 아닌 경우 false를 반환한다.")
    void check_string_is_not_y_return_false() {
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

    @Test
    @DisplayName("문자열이 y이거나 n이면 예외가 발생하지 않는다.")
    void check_string_is_y_or_n_return_nothing() {
        //given
        String yes = "y";
        String no = "n";

        //when //then
        assertThatCode(() -> Answer.checkYesOrNo(yes)).doesNotThrowAnyException();
        assertThatCode(() -> Answer.checkYesOrNo(no)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("문자열이 y이거나 n이 아니면 예외가 발생한다.")
    void check_string_is_not_y_and_n_throw_Exception() {
        //given
        String answer = "test";

        //when //then
        assertThatThrownBy(() -> Answer.checkYesOrNo(answer))
                .isInstanceOf(WithThrowable.class);
    }

    @Test
    @DisplayName("문자열이 null값인 경우 예외가 발생한다.")
    void check_string_is_null_throw_Exception() {
        //given
        String answer = null;

        //when //then
        assertThatThrownBy(() -> Answer.validation(answer))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("문자열이 비어있는 경우 예외가 발생한다.")
    void check_string_is_empty_throw_Exception() {
        //given
        String answer = "";

        //when //then
        assertThatThrownBy(() -> Answer.validation(answer))
                .isInstanceOf(InputEmptyException.class);
    }

    @Test
    @DisplayName("문자열이 빈 칸인 경우 예외가 발생한다.")
    void check_string_is_blank_throw_Exception() {
        //given
        String answer1 = " ";
        String answer2 = "       ";

        //when //then
        assertThatThrownBy(() -> Answer.validation(answer1))
                .isInstanceOf(InputBlankException.class);
        assertThatThrownBy(() -> Answer.validation(answer2))
                .isInstanceOf(InputBlankException.class);
    }

    @Test
    @DisplayName("문자열이 null도 아니고 비어있지도 않고 빈 칸도 아니면 예외가 발생하지 않는다.|")
    void check_string_is_correct_return_nothing() {
        //given
        String answer = "test";

        //when //then
        assertThatCode(() -> Answer.validation(answer))
                .doesNotThrowAnyException();
    }

}

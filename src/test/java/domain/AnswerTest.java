package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
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

    @ParameterizedTest
    @DisplayName("문자열이 y가 아닌 경우 false를 반환한다.")
    @ValueSource(strings = {"", " ", "     ","n", "test"})
    void check_string_is_not_y_return_false(final String answer) {
        //when
        boolean result = Answer.isYes(answer);

        //then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @DisplayName("문자열이 y이거나 n이면 예외가 발생하지 않는다.")
    @ValueSource(strings = {"y", "n"})
    void check_string_is_y_or_n_return_nothing(final String answer) {
        //when //then
        assertThatCode(() -> Answer.validation(answer)).doesNotThrowAnyException();
        assertThatCode(() -> Answer.validation(answer)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("문자열이 y이거나 n이 아니면 예외가 발생한다.")
    @MethodSource("testStringProvider")
    void check_string_is_not_y_and_n_throw_Exception(final String answer, final Class<?> expected) {
        //when //then
        assertThatThrownBy(() -> Answer.validation(answer))
                .isInstanceOf(expected);
    }

    private static Stream<Arguments> testStringProvider() {
        return Stream.of(
                Arguments.of("test", IllegalArgumentException.class),
                Arguments.of("", IllegalArgumentException.class),
                Arguments.of(" ", IllegalArgumentException.class),
                Arguments.of("    ", IllegalArgumentException.class),
                Arguments.of(null, NullPointerException.class)
        );
    }
}

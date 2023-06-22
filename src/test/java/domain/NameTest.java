package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class NameTest {

    @ParameterizedTest
    @DisplayName("Name 인스턴스를 생성할 때 인자로 받는 이름이 잘못된 형식인 경우 예외를 발생시킨다.")
    @MethodSource("nameProvider")
    void validate_name(String name, Class<?> expectedException) {
        //when //then
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(expectedException);

    }

    private static Stream<Arguments> nameProvider() {
        return Stream.of(
                Arguments.of("", IllegalArgumentException.class),
                Arguments.of("  ", IllegalArgumentException.class),
                Arguments.of(null, NullPointerException.class)
        );
    }
}

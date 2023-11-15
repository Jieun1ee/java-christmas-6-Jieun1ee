package christmas.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ChristmasUtilsTest {
    @DisplayName("숫자가 아닌 날짜 입력에 대한 예외 처리")
    @ValueSource(strings = {"a", "ㄱ", "*"})
    @ParameterizedTest
    void checkStrigDateToInt(String input) {
        assertThatThrownBy(() -> ChristmasUtils.stringDateToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 입력에서 comma에 대한 예외 처리")
    @ValueSource(strings = {",,제로콜라-1", ",제로콜라-1,타파스-1", "타파스-1,", "타파스-1 , 제로콜라-1"})
    @ParameterizedTest
    void checkComma(String input) {
        assertThatThrownBy(() -> ChristmasUtils.splitWithComma(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 입력에서 hypen에 대한 예외 처리")
    @ValueSource(strings = {"-1", "제로콜라-", "제로콜라--1", "타파스- 1", "제로콜라 -1"})
    @ParameterizedTest
    void checkHypen(String input) {
        assertThatThrownBy(() -> ChristmasUtils.splitWithHypen(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 주문 입력 폼이 아니면 예외 처리")
    @ValueSource(strings = {"제로콜라1", "제로콜라-", "-1제로콜라"})
    @ParameterizedTest
    void checkOrderForm(String input) {
        assertThatThrownBy(() -> ChristmasUtils.splitWithHypen(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 수량 입력에 대한 예외 처리")
    @ValueSource(strings = {"a", "ㄱ", "*"})
    @ParameterizedTest
    void checkStrigQuantityToInt(String input) {
        assertThatThrownBy(() -> ChristmasUtils.stringQuantityToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Comma로 split 성공")
    @ValueSource(strings = {"타파스-1,제로콜라-1"})
    @ParameterizedTest
    void splitOrderWithComma(String input) {
        List<String> splitResult = ChristmasUtils.splitWithComma(input);
        assertThat(splitResult).containsExactly("타파스-1", "제로콜라-1");
    }

    @DisplayName("Hypen으로 split 성공")
    @ValueSource(strings = {"타파스-1"})
    @ParameterizedTest
    void splitOrderWithHypen(String input) {
        List<String> splitResult = ChristmasUtils.splitWithHypen(input);
        assertThat(splitResult).containsExactly("타파스", "1");
    }

    @DisplayName("parseToInt - date")
    @ValueSource(strings = {"25"})
    @ParameterizedTest
    void parseDateInt(String input) {
        int date = ChristmasUtils.stringDateToInt(input);
        assertThat(date).isEqualTo(25);
    }

    @DisplayName("parseToInt - quantity")
    @ValueSource(strings = {"2"})
    @ParameterizedTest
    void parseQuantityInt(String input) {
        int quantity = ChristmasUtils.stringQuantityToInt(input);
        assertThat(quantity).isEqualTo(2);
    }
}

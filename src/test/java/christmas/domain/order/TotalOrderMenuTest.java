package christmas.domain.order;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TotalOrderMenuTest {
    @DisplayName("20개 이상 시킨 경우 예외 처리")
    @ValueSource(strings = {"타파스-21"})
    @ParameterizedTest
    void checkTotalCount(String input) {
        assertThatThrownBy(() -> new TotalOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모두 음료만 시킨 경우 예외 처리")
    @ValueSource(strings = {"제로콜라-3,레드와인-3"})
    @ParameterizedTest
    void checkAllBeverage(String input) {
        assertThatThrownBy(() -> new TotalOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴를 중복 입력한 경우 예외 처리")
    @ValueSource(strings = {"시저샐러드-1,시저샐러드-1"})
    @ParameterizedTest
    void checkDuplicate(String input) {
        assertThatThrownBy(() ->  new TotalOrderMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
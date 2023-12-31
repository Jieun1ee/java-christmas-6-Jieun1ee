package christmas.domain.order;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OrderTest {
    @DisplayName("Menu에 없는 메뉴 예외처리")
    @CsvSource({"치즈케이크, 1"})
    @ParameterizedTest
    void checkNoMenuName(String menuName, int quantity) {
        assertThatThrownBy(() -> new Order(menuName, quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수량이 0인 경우 예외처리")
    @CsvSource({"타파스, 0"})
    @ParameterizedTest
    void printOrder(String menuName, int quantity) {
        assertThatThrownBy(() -> new Order(menuName, quantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Order 성공케이스")
    @CsvSource({"타파스, 3"})
    @ParameterizedTest
    void checkNoMenu(String menuName, int quantity) {
        Order order = new Order(menuName, quantity);

        assertThat(order.getMenu().menuName).isEqualTo(menuName);
        assertThat(order.getQuantity()).isEqualTo(quantity);
    }
}
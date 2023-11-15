package christmas.domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import christmas.domain.order.Order;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DecemberDiscountTest {
    private static Stream<Arguments> weekdayOrderArguments() {
        return Stream.of(
                Arguments.of(5, List.of(new Order("초코케이크", 1), new Order("초코케이크", 1)), 15000)
        );
    }
    @DisplayName("평일 할인")
    @MethodSource("weekdayOrderArguments")
    @ParameterizedTest
    void calculateWeekdayDiscount(int date, List<Order> totalOrder, int totalCost) {
        int discount = new DecemberDiscount(date, totalOrder ,totalCost).getDiscount();
        boolean isWeekend = new DecemberDiscount(date, totalOrder ,totalCost).getDecemberWeekend();
        assertThat(discount).isEqualTo(4046);
        assertThat(isWeekend).isEqualTo(false);
    }

    private static Stream<Arguments> weekendOrderArguments() {
        return Stream.of(
                Arguments.of(1, List.of(new Order("티본스테이크", 1), new Order("초코케이크", 1)), 15000)
        );
    }
    @DisplayName("평일 할인")
    @MethodSource("weekendOrderArguments")
    @ParameterizedTest
    void calculateWeekendDiscount(int date, List<Order> totalOrder, int totalCost) {
        int discount = new DecemberDiscount(date, totalOrder ,totalCost).getDiscount();
        boolean isWeekend = new DecemberDiscount(date, totalOrder ,totalCost).getDecemberWeekend();
        assertThat(discount).isEqualTo(2023);
        assertThat(isWeekend).isEqualTo(true);
    }
}
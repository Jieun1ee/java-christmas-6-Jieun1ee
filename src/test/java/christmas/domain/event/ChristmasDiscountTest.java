package christmas.domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ChristmasDiscountTest {
    @DisplayName("1일부터 25일 사이에 크리스마스 디데이 할인")
    @CsvSource("25, 15000")
    @ParameterizedTest
    void calculateDiscount(int date, int totalCost) {
        int discount = new ChristmasDiscount(date, totalCost).getDiscount();
        assertThat(discount).isEqualTo(3400);
    }

    @DisplayName("1일부터 25일 사이에 크리스마스 디데이 할인")
    @CsvSource("25, 1000")
    @ParameterizedTest
    void calculateNoDiscount(int date, int totalCost) {
        int discount = new ChristmasDiscount(date, totalCost).getDiscount();
        assertThat(discount).isEqualTo(0);
    }
}
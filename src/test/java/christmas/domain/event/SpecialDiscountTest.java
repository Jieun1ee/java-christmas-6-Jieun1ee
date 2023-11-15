package christmas.domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SpecialDiscountTest {
    @DisplayName("특별할인 날짜 확인")
    @CsvSource({"25, 15000", "17, 15000"})
    @ParameterizedTest
    void calculateDiscount(int date, int totalCost) {
        int discount = new SpecialDiscount(date, totalCost).getDiscount();
        assertThat(discount).isEqualTo(1000);
    }

    @DisplayName("특별할인 대상 날짜가 아닌 경우")
    @CsvSource({"18, 15000", "8, 15000"})
    @ParameterizedTest
    void calculateNoDiscount(int date, int totalCost) {
        int discount = new SpecialDiscount(date, totalCost).getDiscount();
        assertThat(discount).isEqualTo(0);
    }
}
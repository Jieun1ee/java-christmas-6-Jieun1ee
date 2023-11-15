package christmas.domain.event;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GiftEventTest {
    @DisplayName("증정품 증정 가능")
    @CsvSource({"120000", "130000"})
    @ParameterizedTest
    void calculateDiscount(int totalCost) {
        int discount = new GiftEvent(totalCost).getDiscount();
        assertThat(discount).isEqualTo(25000);
    }

    @DisplayName("증정품 증정 불가능")
    @CsvSource({"119000", "50000"})
    @ParameterizedTest
    void calculateNoDiscount(int totalCost) {
        int discount = new GiftEvent(totalCost).getDiscount();
        assertThat(discount).isEqualTo(0);
    }
}
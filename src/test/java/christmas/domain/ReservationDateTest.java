package christmas.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ReservationDateTest {
    @DisplayName("1일부터 31일에 속하지 않은 경우 예외처리")
    @ValueSource(ints = {32, 100, 50})
    @ParameterizedTest
    void checkReservationDate(int input) {
        assertThatThrownBy(() -> new ReservationDate(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1일부터 31일에 속하는 경우")
    @ValueSource(ints = {31, 1, 25, 13})
    @ParameterizedTest
    void printReservationDate(int input) {
        ReservationDate reservationDate = new ReservationDate(input);
        int result = reservationDate.getReservationDate();

        assertThat(result).isEqualTo(input);
    }
}
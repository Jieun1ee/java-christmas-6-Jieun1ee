package christmas.domain;

public class ReservationDate {
    private final int EVENT_START_DAY = 1;
    private final int EVENT_END_DAY = 31;
    private final int date;

    public ReservationDate(int date) {
        checkEventPeriod(date);
        this.date = date;
    }

    private void checkEventPeriod(int date) {
        if (date < EVENT_START_DAY || date > EVENT_END_DAY) {
            throw new IllegalArgumentException(ErrorMessage.DATE_ERROR.getErrorMessage());
        }
    }

    public int getReservationDate() {
        return this.date;
    }
}

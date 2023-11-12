package christmas.domain;

public class ReservationDate {
    private final int date;

    public ReservationDate(int date) {
        this.date = date;
    }

    public int getReservationDate() {
        System.out.println(date);
        return this.date;
    }
}

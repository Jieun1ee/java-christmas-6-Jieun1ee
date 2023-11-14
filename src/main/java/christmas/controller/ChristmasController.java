package christmas.controller;

import christmas.domain.Order;
import christmas.domain.OrderMenu;
import christmas.domain.ReservationDate;
import christmas.utils.ChristmasUtils;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {
    public void run() {
        ReservationDate reservationDate = inputReservationDate();
        int date = reservationDate.getReservationDate();

        OrderMenu orderMenu = new OrderMenu(inputReservationMenu());
        List<Order> orderTotalMenu = orderMenu.getTotalOrder();
        int totalCost = orderMenu.calculateTotalCost();
    }

    private ReservationDate inputReservationDate() {
        return new ReservationDate(ChristmasUtils.stringDateToInt(InputView.visitDate()));
    }

    private String inputReservationMenu() {
        return InputView.menuOrder();
    }
}

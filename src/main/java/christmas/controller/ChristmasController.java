package christmas.controller;

import christmas.domain.event.Benefits;
import christmas.domain.order.Order;
import christmas.domain.order.TotalOrderMenu;
import christmas.domain.ReservationDate;
import christmas.utils.ChristmasUtils;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class ChristmasController {
    public void run() {
        ReservationDate reservationDate = inputReservationDate();
        int date = reservationDate.getReservationDate();

        TotalOrderMenu totalOrderMenu = new TotalOrderMenu(inputReservationMenu());
        List<Order> totalOrder = totalOrderMenu.getTotalOrder();
        int totalCost = totalOrderMenu.calculateTotalCost();
    }

    private ReservationDate inputReservationDate() {
        return new ReservationDate(ChristmasUtils.stringDateToInt(InputView.visitDate()));
    }

    private String inputReservationMenu() {
        return InputView.menuOrder();
    }
}

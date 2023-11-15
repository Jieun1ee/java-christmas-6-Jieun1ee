package christmas.controller;

import christmas.domain.event.ChristmasDiscount;
import christmas.domain.event.DecemberDiscount;
import christmas.domain.event.EventBadge;
import christmas.domain.event.GiftEvent;
import christmas.domain.event.SpecialDiscount;
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

        TotalOrderMenu totalOrderMenu = inputReservationMenu();
        List<Order> totalOrder = totalOrderMenu.getTotalOrder();
        int totalCost = totalOrderMenu.calculateTotalCost();

        printResult(date, totalCost, totalOrder);
    }

    private ReservationDate inputReservationDate() {
        try {
            return new ReservationDate(ChristmasUtils.stringDateToInt(InputView.visitDate()));
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputReservationDate();
        }
    }

    private TotalOrderMenu inputReservationMenu() {
        try {
            return new TotalOrderMenu(InputView.menuOrder());
        } catch (IllegalArgumentException e) {
            OutputView.printException(e);
            return inputReservationMenu();
        }
    }

    private void printResult(int date, int totalCost, List<Order> totalOrder) {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(date, totalCost);
        int christmasDiscountAmount = christmasDiscount.getDiscount();

        GiftEvent giftEvent = new GiftEvent(totalCost);
        int giftDiscount = giftEvent.getDiscount();

        DecemberDiscount decemberDiscount = new DecemberDiscount(date, totalOrder, totalCost);
        int decemberDiscountAmount = decemberDiscount.getDiscount();
        boolean isWeekend = decemberDiscount.getDecemberWeekend();

        SpecialDiscount specialDiscount = new SpecialDiscount(totalCost, date);
        int specialDiscountAmount = specialDiscount.getDiscount();

        int discountAmountExcludingGift = christmasDiscountAmount + decemberDiscountAmount + specialDiscountAmount;
        int totalDiscountAmount = calculateTotalDiscountAmount(giftDiscount, discountAmountExcludingGift);
        int paymentAmount = calculatePaymentAmount(totalCost, discountAmountExcludingGift);
        String eventBadge = calculateBadge(totalDiscountAmount);

        OutputView.printReservationDate(date);
        OutputView.printOrderMenu(totalOrder);
        OutputView.printTotalCost(totalCost);
        OutputView.printGiftMenu(giftDiscount);
        OutputView.printBenefitDetail(christmasDiscountAmount, decemberDiscountAmount, isWeekend,
                specialDiscountAmount, giftDiscount, totalCost);
        OutputView.printTotalDiscount(totalDiscountAmount);
        OutputView.printPayment(paymentAmount);
        OutputView.printEventBadge(eventBadge);
    }

    private int calculateTotalDiscountAmount(int giftDiscount, int discount) {
        return giftDiscount + discount;
    }

    private int calculatePaymentAmount(int totalCost, int discount) {
        return totalCost - discount;
    }

    private String calculateBadge(int totalDiscount) {
        if (totalDiscount >= EventBadge.SANTA.threshold) {
            return EventBadge.SANTA.getBadgeName();
        } else if (totalDiscount >= EventBadge.TREE.threshold) {
            return EventBadge.TREE.getBadgeName();
        } else if (totalDiscount >= EventBadge.STAR.threshold) {
            return EventBadge.STAR.getBadgeName();
        } else {
            return EventBadge.NOTHING.getBadgeName();
        }
    }
}

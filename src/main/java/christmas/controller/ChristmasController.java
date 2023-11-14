package christmas.controller;

import christmas.domain.event.Benefits;
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

        TotalOrderMenu totalOrderMenu = new TotalOrderMenu(inputReservationMenu());
        List<Order> totalOrder = totalOrderMenu.getTotalOrder();
        int totalCost = totalOrderMenu.calculateTotalCost();

        printResult(date, totalCost, totalOrder);
    }

    private ReservationDate inputReservationDate() {
        return new ReservationDate(ChristmasUtils.stringDateToInt(InputView.visitDate()));
    }

    private String inputReservationMenu() {
        return InputView.menuOrder();
    }

    private void printResult(int date, int totalCost, List<Order> totalOrder) {
        int giftDiscount = calculateGiftDiscountAmount(totalCost);
        int discountAmount = calculateDiscountAmount(date, totalCost, totalOrder);
        int totalDiscountAmount = calculateTotalDiscountAmount(giftDiscount, discountAmount);
        int christmasDiscountAmount = calculateChristmasDiscountAmount(date);
        int decemberDiscountAmount = calculateDecemberDiscountAmount(date, totalOrder);
        boolean isWeekend = isWeekendDiscount(date, totalOrder);
        int specialDiscountAmount = calculateSpecialDiscountAmount(date);
        int paymentAmount = calculatePaymentAmount(totalCost, discountAmount);
        String eventBadge = calculateBadge(totalDiscountAmount);

        OutputView.printReservationDate(date);
        OutputView.printOrderMenu(totalOrder);
        OutputView.printTotalCost(totalCost);
        OutputView.printGiftMenu(giftDiscount);
        OutputView.printBenefitDetail(
                christmasDiscountAmount, decemberDiscountAmount, isWeekend, specialDiscountAmount, giftDiscount, totalCost);
        OutputView.printTotalDiscount(totalDiscountAmount);
        OutputView.printPayment(paymentAmount);
        OutputView.printEventBadge(eventBadge);
    }

    private int calculateDiscountAmount(int date, int totalCost, List<Order> totalOrder) {
        Benefits benefits = new Benefits(date, totalCost, totalOrder);
        return benefits.getDiscount();
    }

    private int calculateGiftDiscountAmount(int totalCost) {
        GiftEvent giftEvent = new GiftEvent(totalCost);
        return giftEvent.getGiftDiscount();
    }

    private int calculateTotalDiscountAmount(int giftDiscount, int discount) {
        return giftDiscount + discount;
    }

    private int calculateChristmasDiscountAmount(int date) {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(date);
        return christmasDiscount.getChristmasDiscount();
    }

    private int calculateDecemberDiscountAmount(int date, List<Order> totalOrder) {
        DecemberDiscount decemberDiscount = new DecemberDiscount(date, totalOrder);
        return decemberDiscount.getDecemberDiscount();
    }

    private boolean isWeekendDiscount(int date, List<Order> totalOrder) {
        DecemberDiscount decemberDiscount = new DecemberDiscount(date, totalOrder);
        return decemberDiscount.getDecemberWeekend();
    }

    private int calculateSpecialDiscountAmount(int date) {
        SpecialDiscount specialDiscount = new SpecialDiscount(date);
        return specialDiscount.getSpecialDiscount();
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

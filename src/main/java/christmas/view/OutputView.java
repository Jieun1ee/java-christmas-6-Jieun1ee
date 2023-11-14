package christmas.view;

import christmas.domain.order.Order;
import java.text.DecimalFormat;
import java.util.List;


public class OutputView {
    private static final String PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_COST = "<할인 전 총주문 금액>";
    private static final String GIVEAWAY_MENU = "<증정 메뉴>";
    private static final String GIVEAWAY_CHAMPAGN = "샴페인 1개";
    private static final String NOTHING = "없음";
    private static final String BENEFIT_DETAIL = "<혜택 내역>";
    private static final String CHRISTMAS_DISCOUNT = "크리스마스 디데이 할인: ";
    private static final String WEEKEND_DISCOUNT = "주말 할인: ";
    private static final String WEEKDAY_DISCOUNT = "평일 할인: ";
    private static final String SPECIAL_DISCOUNT = "특별 할인: ";
    private static final String GIFT_DISCOUNT = "증정 이벤트: ";
    private static final String TOTAL_DISCOUNT = "<총혜택 금액>";
    private static final String PAYMENT = "<할인 후 예상 결제 금액>";
    private static final String EVENT_BADGE = "<12월 이벤트 배지>";
    private static final String DECIMALFORMAT = "#,###원";
    private static final String DECIMALFORMAT_MINUS = "-#,###원";
    private final static String ENTER = "\n";
    private final static int NO_DISCOUNT = 0;
    private final static int DISCOUNT_EVENT_THRESHOLD = 10000;
    private static final DecimalFormat decimalFormat = new DecimalFormat(DECIMALFORMAT);
    private static final DecimalFormat decimalFormatMinus = new DecimalFormat(DECIMALFORMAT_MINUS);

    public static void printReservationDate(int date) {
        System.out.printf(PREVIEW_MESSAGE, date);
        System.out.println(ENTER);
    }

    public static void printOrderMenu(List<Order> orderList) {
        System.out.println(ORDER_MENU);

        orderList.forEach((order ->
                System.out.println(order.getMenu().menuName + " " + order.getQuantity() + "개")));
    }

    public static void printTotalCost(int totalCost) {
        System.out.print(ENTER);
        System.out.println(TOTAL_COST);
        System.out.println(decimalFormat.format(totalCost));
    }

    public static void printGiftMenu(int giftDiscount) {
        System.out.print(ENTER);
        System.out.println(GIVEAWAY_MENU);
        if (giftDiscount != NO_DISCOUNT) {
            System.out.println(GIVEAWAY_CHAMPAGN);
        }
        if (giftDiscount == NO_DISCOUNT) {
            System.out.println(NOTHING);
        }
    }

    public static void printBenefitDetail(int christmasDiscountAmount, int decemberDiscountAmount, boolean isWeekend,
                                          int specialDiscountAmount, int giftDiscount, int totalCost) {
        System.out.print(ENTER);
        System.out.println(BENEFIT_DETAIL);
        if (totalCost >= DISCOUNT_EVENT_THRESHOLD) {
            printChristmasDiscount(christmasDiscountAmount);
            printDecemberDiscount(decemberDiscountAmount, isWeekend);
            printSpecialDiscount(specialDiscountAmount);
            printGiftDiscount(giftDiscount);
        }
        if (totalCost < DISCOUNT_EVENT_THRESHOLD) {
            System.out.println(NOTHING);
        }
    }

    private static void printChristmasDiscount(int christmasDiscountAmount) {
        if (christmasDiscountAmount != NO_DISCOUNT) {
            System.out.println(CHRISTMAS_DISCOUNT + decimalFormatMinus.format(christmasDiscountAmount));
        }
    }

    private static void printDecemberDiscount(int decemberDiscountAmount, boolean isWeekend) {
        if (isWeekend) {
            System.out.println(WEEKEND_DISCOUNT + decimalFormatMinus.format(decemberDiscountAmount));
        }
        if (!isWeekend) {
            System.out.println(WEEKDAY_DISCOUNT + decimalFormatMinus.format(decemberDiscountAmount));
        }
    }

    private static void printSpecialDiscount(int specialDiscountAmount) {
        if (specialDiscountAmount != NO_DISCOUNT) {
            System.out.println(SPECIAL_DISCOUNT + decimalFormatMinus.format(specialDiscountAmount));
        }
    }

    private static void printGiftDiscount(int giftDiscount) {
        if (giftDiscount != NO_DISCOUNT) {
            System.out.println(GIFT_DISCOUNT + decimalFormatMinus.format(giftDiscount));
        }
    }

    public static void printTotalDiscount(int totalDiscount) {
        System.out.print(ENTER);
        System.out.println(TOTAL_DISCOUNT);
        if (totalDiscount == NO_DISCOUNT) {
            System.out.println(decimalFormat.format(totalDiscount));
        }
        if (totalDiscount != NO_DISCOUNT) {
            System.out.println(decimalFormatMinus.format(totalDiscount));
        }
    }

    public static void printPayment(int payment) {
        System.out.print(ENTER);
        System.out.println(PAYMENT);
        System.out.println(decimalFormat.format(payment));
    }
    
    public static void printEventBadge(String badge) {
        System.out.print(ENTER);
        System.out.println(EVENT_BADGE);
        System.out.println(badge);
    }
}

package christmas.domain.event;

import christmas.domain.order.Order;
import java.util.List;

public class Benefits {
    private final int DISCOUNT_EVENT_THRESHOLD = 10000;
    private final int NO_DISCOUNT = 0;
    private int discount;

    public Benefits(int date, int totalCost, List<Order> totalOrder) {
        this.discount = applyDiscount(date, totalCost, totalOrder);
    }

    private int applyDiscount(int date, int totalCost, List<Order> totalOrder) {
        if (checkTotalCost(totalCost)) {
            ChristmasDiscount christmasDiscount = new ChristmasDiscount(date);
            int chrismasDiscountAmount = christmasDiscount.getChristmasDiscount();

            DecemberDiscount decemberDiscount = new DecemberDiscount(date, totalOrder);
            int decemberDiscountAmount = decemberDiscount.getDecemberDiscount();

            SpecialDiscount specialDiscount = new SpecialDiscount(date);
            int specialDiscountAmount = specialDiscount.getSpecialDiscount();

            return chrismasDiscountAmount + decemberDiscountAmount + specialDiscountAmount;
        }
        return NO_DISCOUNT;
    }

    public boolean checkTotalCost(int totalCost){
        return totalCost >= DISCOUNT_EVENT_THRESHOLD;
    }

    public int getDiscount() {
        return discount;
    }
}

package christmas.domain.event;

import christmas.domain.order.Order;
import java.util.List;

public class DecemberDiscount extends Discounts {
    private final int DECEMBER_DISCOUNT_AMOUNT = 2023;
    private final int DAYS_IN_WEEK = 7;
    private final int NO_DISCOUNT = 0;
    private final int discount;
    private final boolean isWeekendDiscount;
    private final List<Order> totalOrder;

    public DecemberDiscount(int date, List<Order> totalOrder, int totalcost) {
        super(totalcost);
        this.totalOrder = totalOrder;
        this.discount = calculate(date);
        this.isWeekendDiscount = validateWeekend(date);
    }

    @Override
    int calculate(int date) {
        // 1일, 2일 (주말) 부터 시작
        if (validateWeekend(date) && checkTotalCost(totalCost)) {
            return multiple(countMain(totalOrder), DECEMBER_DISCOUNT_AMOUNT);
        }
        if (!validateWeekend(date) && checkTotalCost(totalCost)) {
            // 3, 4, 5, 6, 7 (평일)
            return multiple(countDessert(totalOrder), DECEMBER_DISCOUNT_AMOUNT);
        }
        return NO_DISCOUNT;
    }

    private int countMain(List<Order> totalOrder) {
        return totalOrder.stream()
                .filter(order -> order.getMenu().getMenuType().equals("Main"))
                .mapToInt(Order::getQuantity)
                .sum();
    }

    private int countDessert(List<Order> totalOrder) {
        return totalOrder.stream()
                .filter(order -> order.getMenu().getMenuType().equals("Dessert"))
                .mapToInt(Order::getQuantity)
                .sum();
    }

    private int multiple(int count, int discount) {
        // 이 0과 NO_DISCOUNT는 다른 의미이므로 0을 그대로 입력
        if (count > 0) {
            return count * discount;
        }
        // 없는 경우 모두 0을 반환
        return NO_DISCOUNT;
    }

    private boolean validateWeekend(int date) {
        return (date % DAYS_IN_WEEK == 1) || (date % DAYS_IN_WEEK == 2);
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    public boolean getDecemberWeekend() {
        return isWeekendDiscount;
    }
}

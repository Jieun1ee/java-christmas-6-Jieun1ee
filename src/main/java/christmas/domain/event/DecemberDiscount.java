package christmas.domain.event;

import christmas.domain.order.Order;
import java.util.List;

public class DecemberDiscount {
    private final int DECEMBER_DISCOUNT_AMOUNT = 2023;
    private final int DAYS_IN_WEEK = 7;
    private final int NO_DISCOUNT = 0;
    private int discount;

    public DecemberDiscount(int date, List<Order> totalOrder) {
        this.discount = calculateDecemberDiscount(date, totalOrder);
    }

    private int calculateDecemberDiscount(int date, List<Order> totalOrder) {
        // 1일, 2일 (주말) 부터 시작
        if ((date % DAYS_IN_WEEK == 1) || (date % DAYS_IN_WEEK == 2)) {
            return multiple(countMain(totalOrder), DECEMBER_DISCOUNT_AMOUNT);
        }
        // 3, 4, 5, 6, 7 (평일)
        return multiple(countDessert(totalOrder), DECEMBER_DISCOUNT_AMOUNT);
    }

    private int countMain(List<Order> totalOrder) {
        return (int) totalOrder.stream()
                .filter(order -> order.getMenu().getMenuType().equals("Main"))
                .count();
    }

    private int countDessert(List<Order> totalOrder) {
        return (int) totalOrder.stream()
                .filter(order -> order.getMenu().getMenuType().equals("Dessert"))
                .count();
    }

    private int multiple(int count, int discount) {
        // 이 0과 NO_DISCOUNT는 다른 의미이므로 0을 그대로 입력
        if (count > 0) {

            return count * discount;
        }
        // 없는 경우 모두 0을 반환
        return NO_DISCOUNT;
    }

    public int getDecemberDiscount() {
        return discount;
    }
}

package christmas.domain.event;

public class SpecialDiscount extends Discounts{
    private final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private final int DAYS_IN_WEEK = 7;
    private final int NO_DISCOUNT = 0;
    private final int CHRISTMAS = 25;
    private int discount;

    public SpecialDiscount(int date, int totalCost) {
        super(totalCost);
        this.discount = calculate(date);
    }

    @Override
    int calculate(int date) {
        // 3일부터 일주일마다 진행 & 크리스마스
        if ((date % DAYS_IN_WEEK == 3 || date == CHRISTMAS) && checkTotalCost(totalCost)) {
            return SPECIAL_DISCOUNT_AMOUNT;
        }
        return NO_DISCOUNT;
    }

    @Override
    public int getDiscount() {
        return discount;
    }
}

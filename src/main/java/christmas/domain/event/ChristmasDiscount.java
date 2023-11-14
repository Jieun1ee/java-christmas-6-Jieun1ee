package christmas.domain.event;

public class ChristmasDiscount {
    private final int BASIC_DISCOUNT_AMOUNT = 1000;
    private final int DISCOUNT_INCREMENT_AMOUNT = 100;
    private final int D_DAY_DISCOUNT_START_DAY = 1;
    private final int D_DAY_DISCOUNT_END_DAY = 25;
    private final int NO_DISCOUNT = 0;
    private int discount;

    public ChristmasDiscount(int date) {
        this.discount = calculateChristmasDiscount(date);
    }

    private int calculateChristmasDiscount(int date) {
        if (shouldApplyChristmasDiscount(date)) {
            // 1일부터 시작이므로 date - 1
            return (date - 1) * DISCOUNT_INCREMENT_AMOUNT + BASIC_DISCOUNT_AMOUNT;
        }
        return NO_DISCOUNT;
    }

    private boolean shouldApplyChristmasDiscount(int date) {
        return date >= D_DAY_DISCOUNT_START_DAY && date <= D_DAY_DISCOUNT_END_DAY;
    }

    public int getChristmasDiscount() {
        return discount;
    }

}

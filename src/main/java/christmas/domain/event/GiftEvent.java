package christmas.domain.event;

public class GiftEvent extends Discounts {
    private final int GIFT_EVENT_THRESHOLD = 120000;
    private final int CHAMPAGNE_PRICE = 25000;
    private final int NO_DISCOUNT = 0;
    private int discount;

    public GiftEvent(int totalCost) {
        super(totalCost);
        this.discount = calculate(totalCost);
    }

    @Override
    int calculate(int date) {
        if (applyGiveawayEvent(totalCost)) {
            return CHAMPAGNE_PRICE;
        }
        return NO_DISCOUNT;
    }

    @Override
    public int getDiscount() {
        return discount;
    }

    private int calculateGiftEvent(int totalCost) {
        if (applyGiveawayEvent(totalCost)) {
            return CHAMPAGNE_PRICE;
        }
        return NO_DISCOUNT;
    }

    private boolean applyGiveawayEvent(int totalCost) {
        return totalCost >= GIFT_EVENT_THRESHOLD;
    }
}

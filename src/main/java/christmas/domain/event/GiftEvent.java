package christmas.domain.event;

public class GiftEvent {
    private final int GIFT_EVENT_THRESHOLD = 120000;
    private final int CHAMPAGNE_PRICE = 25000;
    private final int NO_DISCOUNT = 0;
    private int discount;

    public GiftEvent(int totalCost) {
        this.discount = calculateGiftEvent(totalCost);
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

    public int getGiftDiscount() {
        return discount;
    }
}

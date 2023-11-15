package christmas.domain.event;

public abstract class Discounts {
    protected final int DISCOUNT_EVENT_THRESHOLD = 10000;
    protected int totalCost;

    Discounts(int totalCost){
        this.totalCost = totalCost;
    }

    abstract int calculate(int date);

    public abstract int getDiscount();
    final boolean checkTotalCost(int totalCost){
        return totalCost >= DISCOUNT_EVENT_THRESHOLD;
    }
}

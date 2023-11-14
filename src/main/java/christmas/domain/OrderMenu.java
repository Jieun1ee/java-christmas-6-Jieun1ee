package christmas.domain;

import christmas.utils.ChristmasUtils;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMenu {
    private final List<Order> totalOrder;

    public OrderMenu(String input) {
        this.totalOrder = createTotalOrderMenu(input);
        checkTotalCount();
    }

    public List<Order> createTotalOrderMenu(String input) {
        List<String> orders = ChristmasUtils.splitWithComma(input);

        return orders.stream()
                .map(order -> {
                    List<String> orderComponents = ChristmasUtils.splitWithHypen(order);
                    String menuName = orderComponents.get(0);
                    int menuQuantity = ChristmasUtils.stringQuantityToInt(orderComponents.get(1));
                    return createOrder(menuName, menuQuantity);
                })
                .collect(Collectors.toList());
    }

    public Order createOrder(String menuName, int menuCount) {
        return new Order(menuName, menuCount);
    }

    public int calculateTotalCost() {
        return totalOrder.stream()
                .mapToInt(order -> order.getMenu().menuPrice * order.getQuantity())
                .sum();
    }

    public List<Order> getTotalOrder() {
        return totalOrder;
    }

    private void checkTotalCount() {
        int totalCount = totalOrder.stream()
                .mapToInt(Order::getQuantity)
                .sum();

        if (totalCount > 20) {
            throw new IllegalArgumentException("[ERROR] 총 수량이 20 초과");
        }
    }
}

package christmas.domain.order;

import christmas.domain.ErrorMessage;
import christmas.utils.ChristmasUtils;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TotalOrderMenu {
    private final List<Order> totalOrder;

    public TotalOrderMenu(String input) {
        this.totalOrder = createTotalOrderMenu(input);
        validateOrderMenu();
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

    private void validateOrderMenu() {
        checkMenuType();
        checkDuplicate();
        checkTotalCount();
    }

    private void checkTotalCount() {
        int totalCount = totalOrder.stream()
                .mapToInt(Order::getQuantity)
                .sum();

        if (totalCount > 20) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getErrorMessage());
        }
    }

    private void checkMenuType() {
        if (isAllBeverage()) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getErrorMessage());
        }
    }

    private boolean isAllBeverage() {
        return totalOrder.stream()
                .allMatch(order -> "Beverage".equals(order.getMenu().getMenuType()));
    }

    private void checkDuplicate() {
        Set<Order> orderSet = new HashSet<>();
        totalOrder.forEach(order -> {
            if (!orderSet.add(order)) {
                throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getErrorMessage());
            }
        });
    }
}

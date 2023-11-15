package christmas.domain.order;

import christmas.domain.ErrorMessage;
import java.util.Arrays;

public class Order {
    private final Menu menu;
    private final int quantity;

    public Order(String menu, int quantity) {
        validateQuantity(quantity);
        this.menu = getMenuName(menu);
        this.quantity = quantity;
    }

    private Menu getMenuName(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.menuName.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getErrorMessage()));
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_ERROR.getErrorMessage());
        }
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return menu.toString();
    }
}

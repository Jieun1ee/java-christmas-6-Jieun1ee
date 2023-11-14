package christmas.domain.order;

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
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 여기는 없는 값을 입력하면, 유효하지 않은 주문입니다. 다시 입력해 주세요."));
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("수량은 1 이상이어야 합니다.");
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

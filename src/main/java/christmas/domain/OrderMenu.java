package christmas.domain;

import christmas.Menu;
import java.util.EnumMap;

public class OrderMenu {
    EnumMap<Menu, Integer> menuQuantity;

    public OrderMenu() {
        menuQuantity = new EnumMap<>(Menu.class);
    }
}

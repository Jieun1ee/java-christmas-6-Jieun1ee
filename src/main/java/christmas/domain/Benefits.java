package christmas.domain;

import christmas.Menu;
import java.util.EnumMap;

public class Benefits {
    public Benefits(int date, EnumMap<Menu, Integer> orderList) {
    }

    public int totalCost(EnumMap<Menu, Integer> orderList) {
        return orderList.entrySet().stream()
                .mapToInt(entry -> entry.getKey().menuPrice * entry.getValue())
                .sum();
    }

}

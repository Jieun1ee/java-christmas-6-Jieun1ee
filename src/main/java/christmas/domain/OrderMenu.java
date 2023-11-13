package christmas.domain;

import christmas.Menu;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class OrderMenu {
    EnumMap<Menu, Integer> orderList;

    public OrderMenu() {
        orderList = new EnumMap<>(Menu.class);
    }

    // depth : 2 -> 함수 분리 해야 함
    public EnumMap<Menu, Integer> menuList(List<String> parseToList) {
        return parseToList.stream()
                .map(item -> item.split("-"))
                .collect(Collectors.toMap(
                        parts -> getMenuName(parts[0]),
                        parts -> Integer.parseInt(parts[1]),
                        (existing, replacement) -> {
                            throw new IllegalStateException("[ERROR] 중복 ");
                        },
                        () -> new EnumMap<>(Menu.class)
                ));
    }

    // 메쏘드 명 수정 하고 싶음
    private Menu getMenuName(String menuName) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.menuName.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 여기는 없는 값을 입력하면, 유효하지 않은 주문입니다. 다시 입력해 주세요."));
    }
}

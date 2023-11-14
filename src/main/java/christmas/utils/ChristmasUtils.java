package christmas.utils;

import java.util.Arrays;
import java.util.List;

public class ChristmasUtils {
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String HYPEN = "-";

    public static int stringDateToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static List<String> splitWithComma(String input) {
        validateComma(input);
        return Arrays.asList(input.split(COMMA));
    }

    private static void validateComma(String input) {
        if (input.startsWith(COMMA) || input.endsWith(COMMA)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
        if (input.contains(COMMA + COMMA) || input.contains(COMMA + SPACE) || input.contains(SPACE + COMMA)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateHypen(String input) {
        if (input.startsWith(HYPEN) || input.endsWith(HYPEN)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
        if (input.contains(HYPEN + HYPEN)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
        if (input.contains(SPACE + HYPEN) || input.contains(HYPEN + SPACE)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
    }

    public static List<String> splitWithHypen(String input) {
        validateHypen(input);
        List<String> order = List.of(input.split(HYPEN));
        validateOrderForm(order);
        return order;
    }

    private static void validateOrderForm(List<String> order) {
        if (order.size() != 2) {
            throw new IllegalArgumentException("올바른 형태가 아님.");
        }
    }

    public static int stringQuantityToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

}

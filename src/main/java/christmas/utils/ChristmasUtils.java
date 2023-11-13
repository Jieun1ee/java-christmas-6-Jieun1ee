package christmas.utils;

import christmas.Menu;
import java.util.Arrays;
import java.util.EnumMap;
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

    public static List<String> parseToList(String input) {
        validateComma(input);
        validateHypen(input);
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
        if (input.contains(HYPEN + HYPEN) || input.contains(COMMA + HYPEN) || input.contains(HYPEN + COMMA)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
        if (input.contains(SPACE + HYPEN) || input.contains(HYPEN + SPACE)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
    }


//    public static EnumMap<Menu, Integer> parseToOrder(String input) {
//        List<String> parseWithComma = parseToList(input);
//
//        return
//
//    }
}

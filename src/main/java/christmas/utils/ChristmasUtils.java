package christmas.utils;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class ChristmasUtils {
    private static final String DELIMITER = ",";
    private static final String SPACE = " ";

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
    }

    private static List<String> parseToList(String input) {
        validateDelimiter(input);
        return Arrays.asList(input.split(DELIMITER));
    }

    private static void validateDelimiter(String input) {
        if (input.startsWith(DELIMITER) || input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
        if (input.contains(DELIMITER + DELIMITER) || input.contains(DELIMITER + SPACE)) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 입력입니다. 다시 입력해 주세요.");
        }
    }
}

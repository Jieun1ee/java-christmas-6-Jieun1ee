package christmas.utils;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class ChristmasUtils {
    private static final String DELIMITER = ",";

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private static List<String> parseToList(String input) {
        return Arrays.asList(input.split(DELIMITER));
    }
}

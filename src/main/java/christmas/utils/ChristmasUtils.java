package christmas.utils;

public class ChristmasUtils {
    public int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}

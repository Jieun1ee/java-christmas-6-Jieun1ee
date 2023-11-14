package christmas.view;

import christmas.Menu;
import christmas.domain.Order;
import christmas.domain.OrderMenu;
import java.text.DecimalFormat;
import java.util.EnumMap;
import java.util.List;
import org.mockito.internal.matchers.Or;

public class OutputView {
    private static final String PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private final static String ENTER = "\n";

    public static void output(int date) {
        System.out.printf(PREVIEW_MESSAGE, date);
        System.out.println(ENTER);
    }
}

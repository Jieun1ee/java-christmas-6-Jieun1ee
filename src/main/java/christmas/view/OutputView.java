package christmas.view;

import christmas.domain.Order;
import christmas.domain.OrderMenu;
import java.text.DecimalFormat;
import java.util.List;
import org.mockito.internal.matchers.Or;


public class OutputView {
    private static final String PREVIEW_MESSAGE = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MENU = "<주문 메뉴>";
    private static final String TOTAL_COST = "<할인 전 총주문 금액>";
    private static final String DECIMALFORMAT = "#,###원";
    private final static String ENTER = "\n";

    private static final DecimalFormat decimalFormat = new DecimalFormat(DECIMALFORMAT);


    public static void output(int date, List<Order> orderList, int totalCost) {
        System.out.printf(PREVIEW_MESSAGE, date);
        System.out.println(ENTER);
        printOrderMenu(orderList);
        printTotalCost(totalCost);
    }

    private static void printOrderMenu(List<Order> orderList) {
        System.out.println(ORDER_MENU);

        orderList.forEach((order ->
                System.out.println(order.getMenu().menuName + " " + order.getQuantity() + "개")));
    }

    private static void printTotalCost(int totalCost) {
        System.out.print(ENTER);
        System.out.println(TOTAL_COST);
        System.out.println(decimalFormat.format(totalCost));
    }
}

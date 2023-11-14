package christmas.domain.order;

public enum Menu {
    MUSHROOM_SOUP("Appetizer", "양송이수프", 6000),
    TAPAS("Appetizer", "타파스", 5500),
    CAESAR_SALAD("Appetizer", "시저샐러드", 8000),
    T_BONE_STEAK("Main", "티본스테이크", 55000),
    BARBECUE_RIBS("Main", "바비큐립", 54000),
    SEAFOOD_PASTA("Main", "해산물파스타", 35000),
    CHRISTMAS_PASTA("Main", "크리스마스파스타", 25000),
    CHOCO_CAKE("Dessert", "초코케이크", 15000),
    ICE_CREAM("Dessert", "아이스크림", 5000),
    ZERO_COKE("Beverage", "제로콜라", 3000),
    RED_WINE("Beverage", "레드와인", 60000),
    CHAMPAGNE("Beverage", "샴페인", 25000);

    private final String menuType;
    public final String menuName;
    public final Integer menuPrice;

    Menu(String menuType, String menuName, Integer menuPrice) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    public String getMenuType() {
        return menuType;
    }
}

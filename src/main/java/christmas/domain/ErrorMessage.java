package christmas.domain;

public enum ErrorMessage {
    DATE_ERROR("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER_ERROR("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String ErrorMessage;

    ErrorMessage(String ErrorMessage){
        this.ErrorMessage = ErrorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }
}

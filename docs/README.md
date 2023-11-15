# 🎄 크리스마스 이벤트 🎄

## 기능 구현 구조 

## VIEW
- InputView : 입력 담당
- OutputView : 출력 담당

## DOMAIN
-  ReservationDate : 예약 날짜를 validate 하고, 저장
### - EVENT
- Discounts : abstract class
- ChristmasDiscount : 크리스마스 디데이 할인 
- DecemberDiscount : 평일 할인 혹은 주말 할인
- SpecialDiscount : 특별할인
- GiftEvent : 샴페인 증정 이벤트
- EventBadge : Enum class. 이벤트 배지를 저장

### - ORDER
- Menu : Enum class. 메뉴를 저장 
- Order : 주문 하나의 validate를 위해 생성
- TotalOrderMenu : List<Order>의 형식으로 모든 주문을 저장

## CONTROLLER
- Domain 로직으로부터 데이터를 받아 View로 전달

## UTILS
- [X] parseToInt -> 날짜
- [X] split ","으로
- [X] split "-"으로
- [X] parseToInt -> 주문메뉴수량

## exception
- [X] 1부터 31이 아닌 숫자
- [X] 음료만 주문한 경우
- [X] 주문의 개수가 20개 초과인 경우
- [X] 메뉴판에 없는 메뉴
- [X] 메뉴 중복 입력
- [X] 형식이 다른 경우 
- [X] 메뉴 주문 숫자가 1 이상이 아닌 경우
- [X] 메뉴 주문 숫자가 String인 경우
- [X] validate ","
- [X] validate "-"
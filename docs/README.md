# 🎄 크리스마스 이벤트 🎄

## 크리스마스 이벤트 목표 ❗️

1. 중복된 할인과 증정을 허용해서, 고객들이 혜택을 많이 받는다는 것을 체감할 수 있게 하는 것
2. 올해 12월에 지난 5년 중 최고의 판매 금액을 달성
3. 12월 이벤트 참여 고객의 5%가 내년 1월 새해 이벤트에 재참여하는 것


## 12월 크리스마스 이벤트 계획
* **크리스마스 디데이 할인**
* 이벤트 기간: 2023.12.1 ~ 2023.12.25
  * 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
  * 총주문 금액에서 해당 금액만큼 할인
  * (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
* **평일 할인(일요일~목요일)**: 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
* **주말 할인(금요일, 토요일)**: 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
* **특별 할인**: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
* **증정 이벤트**: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
* 이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용

## 혜택에 따른 이벤트 배지 부여
* 총혜택 금액에 따라 다른 이벤트 배지를 부여합니다. 이 배지는 2024 새해 이벤트에서 활용할 예정입니다. 배지에 따라 새해 이벤트 참여 시, 각각 다른 새해 선물을 증정할 예정입니다.
  * 5천 원 이상: 별
  * 1만 원 이상: 트리
  * 2만 원 이상: 산타

## 고객에게 안내할 주의 사항
* 총주문 금액 10,000원 이상부터 이벤트가 적용됩니다.
* 음료만 주문 시, 주문할 수 없습니다.
* 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다. 
  * (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)

## 출력 예시
~~~
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
~~~

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

## EXCEPTION
- ErrorMessage : 에러 메세지를 저장.
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
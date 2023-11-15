package christmas.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasControllerTest extends NsTest {
    @DisplayName("예시에 맞는 총 출력_크리스마스 이전_평일할인")
    @Test
    void 모든_결과값_출력_1() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "티본스테이크 1개",
                    "바비큐립 1개",
                    "초코케이크 2개",
                    "제로콜라 1개",
                    "142,000원",
                    "샴페인 1개",
                    "크리스마스 디데이 할인: -1,200원\n" + "평일 할인: -4,046원\n"
                            + "특별 할인: -1,000원\n" + "증정 이벤트: -25,000원",
                    "-31,246원",
                    "135,754원",
                    "산타"
            );
        });
    }

    @DisplayName("예시에 맞는 총 출력_크리스마스 이전_주말할인")
    @Test
    void 모든_결과값_출력_2() {
        assertSimpleTest(() -> {
            run("1", "티본스테이크-1,바비큐립-1,시저샐러드-1");
            assertThat(output()).contains(
                    "티본스테이크 1개",
                    "바비큐립 1개",
                    "시저샐러드 1개",
                    "117,000원",
                    "없음",
                    "크리스마스 디데이 할인: -1,000원\n" + "주말 할인: -4,046원\n",
                    "-5,046원",
                    "111,954원",
                    "별"
            );
        });
    }

    @DisplayName("예시에 맞는 총 출력_크리스마스 당일")
    @Test
    void 모든_결과값_출력_3() {
        assertSimpleTest(() -> {
            run("25", "티본스테이크-2,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "티본스테이크 2개",
                    "바비큐립 1개",
                    "초코케이크 2개",
                    "제로콜라 1개",
                    "197,000원",
                    "샴페인 1개",
                    "크리스마스 디데이 할인: -3,400원\n" + "평일 할인: -4,046원\n"
                            + "특별 할인: -1,000원\n" + "증정 이벤트: -25,000원",
                    "-33,446원",
                    "188,554원",
                    "산타"
            );
        });
    }

    @Override
    protected void runMain() {
        ChristmasController christmasController = new ChristmasController();
        christmasController.run();
    }
}
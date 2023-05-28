package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottoTest {
    private static final int LOTTO_NUMS = 6;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String LOTTO_BOUND_ERORR_MESSAGE = MIN_NUM + "에서 " + MAX_NUM + "까지 범위가 아닙니다.";
    private static final String BONUS_BOUND_ERORR_MESSAGE = MIN_NUM + "에서 " + MAX_NUM + "까지 범위가 아닙니다.";
    private static final String LOTTO_DUPLICATE_ERORR_MESSAGE = "중복되는 로또 번호가 있습니다.";

    public static Lotto lottoFixture(Integer... numbers) {
        return new Lotto(Arrays.asList(numbers));
    }

    @Test
    @DisplayName("정상 범위 로또 생성")
    void normalLotto() {
        //give // when
        Lotto lotto = lottoFixture(1, 8, 23, 41, 42, 45);

        //then
        Assertions.assertThat(lotto.getLotto().size()).isEqualTo(6);

    }

    @Test
    @DisplayName("최대 범위 로또 생성 오류")
    void maxLotto() {
        Assertions.assertThatThrownBy(() -> {
                    Lotto lotto = lottoFixture(1, 8, 23, 41, 42, 48);
                }).isInstanceOf(RuntimeException.class)
                .hasMessage(LOTTO_BOUND_ERORR_MESSAGE);

    }

    @Test
    @DisplayName("최소 범위 로또 생성 오류")
    void minLotto() {
        Assertions.assertThatThrownBy(() -> {
                    Lotto lotto = lottoFixture(-1, 8, 23, 41, 42, 45);
                }).isInstanceOf(RuntimeException.class)
                .hasMessage(LOTTO_BOUND_ERORR_MESSAGE);

    }

    @Test
    @DisplayName("중복 로또 생성 오류")
    void duplicateLotto() {
        Assertions.assertThatThrownBy(() -> {
                    Lotto lotto = lottoFixture(1, 1, 1, 41, 42, 45);
                }).isInstanceOf(RuntimeException.class)
                .hasMessage(LOTTO_DUPLICATE_ERORR_MESSAGE);

    }
}

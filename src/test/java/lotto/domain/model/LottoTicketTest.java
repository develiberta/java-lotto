package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.InvalidLottoTicketException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");
    }

    @Test
    @DisplayName("6개 이외의 개수의 숫자를 생성자에 전달하면 InvalidLottoTicketException 예외를 throw 한다.")
    void createFromList_out_of_bounds() {
        assertThatThrownBy(() -> LottoTicket.of("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(InvalidLottoTicketException.class);
        assertThatThrownBy(() -> LottoTicket.of("1, 2, 3, 4, 5"))
                .isInstanceOf(InvalidLottoTicketException.class);
    }

    @Test
    @DisplayName("반복된 숫자가 있으면 InvalidLottoTicketException 예외를 throw 한다.")
    void createFromList_repeated_numbers() {
        assertThatThrownBy(() -> LottoTicket.of("1, 1, 3, 4, 5, 6"))
                .isInstanceOf(InvalidLottoTicketException.class);
    }

    @Test
    @DisplayName("번호가 로또에 포함되어 있다.")
    void contains_number_in_ticket() {
        LottoNumber lottoNumber = LottoNumber.of(6);
        assertThat(lottoTicket.contains(lottoNumber)).isTrue();
    }

    @Test
    @DisplayName("번호가 로또에 포함되어 있지 않다.")
    void contains_number_not_in_ticket() {
        LottoNumber lottoNumber = LottoNumber.of(8);
        assertThat(lottoTicket.contains(lottoNumber)).isFalse();
    }

    @Test
    @DisplayName("로또가 1등 당첨되었다.")
    void findRank_first() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 3, 4, 5, 6");
        LottoRank lottoRank = lottoTicket.findRank(winningTicket);
        assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("로또가 3등 당첨되었다.")
    void findRank_third() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 3, 4, 5, 7");
        LottoRank lottoRank = lottoTicket.findRank(winningTicket);
        assertThat(lottoRank).isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("로또가 4등 당첨되었다.")
    void findRank_fourth() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 3, 4, 7, 8");
        LottoRank lottoRank = lottoTicket.findRank(winningTicket);
        assertThat(lottoRank).isEqualTo(LottoRank.FOURTH);
    }

    @Test
    @DisplayName("로또가 5등 당첨되었다.")
    void findRank_fifth() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 3, 7, 8, 9");
        LottoRank lottoRank = lottoTicket.findRank(winningTicket);
        assertThat(lottoRank).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("로또 당첨 결과 꽝!")
    void findRank_miss() {
        LottoTicket winningTicket = LottoTicket.of("1, 2, 9, 10, 11, 12");
        LottoRank lottoRank = lottoTicket.findRank(winningTicket);
        assertThat(lottoRank).isEqualTo(LottoRank.MISS);
    }
}

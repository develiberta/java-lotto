package autolotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        List<Lotto> lottoTickets = new ArrayList<>();
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottoTickets.add(new Lotto(Arrays.asList(1, 2, 3, 4, 7, 8)));
        lottoStatistics = new LottoStatistics(lottoTickets, new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void lottoStatistics_당첨건확인() {
        Map<Rank, Integer> rankIntegerMap = lottoStatistics.calcuratorRankCount();
        assertThat(rankIntegerMap).hasSize(2);
        assertThat(rankIntegerMap.get(Rank.FIRST)).isEqualTo(1);
        assertThat(rankIntegerMap.get(Rank.THIRD)).isEqualTo(2);
    }

    @Test
    void lottoStatistics_수익률확인() {
        Map<Rank, Integer> rankIntegerMap = lottoStatistics.calcuratorRankCount();
        double profit = lottoStatistics.calcuratorProfit(rankIntegerMap, 3);
        assertThat(profit).isEqualTo(666700.0);
    }
}
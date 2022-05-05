package step2.view;

import step2.domain.LottoWinners;
import step2.domain.Rank;

import java.util.List;

public class ResultView {
    public void lottoCount(int number) {
        System.out.println(number + "개를 구매했습니다");
    }

    public void displayLottoNumber(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void display(LottoWinners winners, double rate) {
        for (Rank rank : Rank.values()) {
            System.out.println(rank.matchCount + "개 일치" + "(" + rank.price +"원)-" + winners.countByRank(rank) + "개");
        }
        System.out.println("총 수익률은 " + Math.floor(rate * 100)/100.0 + "% 입니다");
    }
}
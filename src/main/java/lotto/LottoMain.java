package lotto;

import lotto.domain.Lotto;
import lotto.domain.Ranks;
import lotto.domain.Ticket;
import lotto.domain.WinningTicket;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoMain {
    public static void main(String[] args) {
        int amount = InputView.inputAmount();

        Lotto lotto = new Lotto(amount);
        ResultView.printTicketCount(lotto.getTicketCount());
        ResultView.printTickeList(lotto.getTicketList());

        List<Integer> winningNumbers = InputView.inputWinnigNumber();
        int bonusNumber = InputView.inputBonusNumber();
        Ticket lottoWinningTicket = Ticket.of(winningNumbers);
        WinningTicket winningTicket = new WinningTicket(lottoWinningTicket, bonusNumber);
        Ranks ranks = lotto.rankedWinningNumbers(winningTicket);

        ResultView.printLottoResult(ranks);
        ResultView.printIncomePercentage(ranks.caculateIncomePercentage());
    }
}
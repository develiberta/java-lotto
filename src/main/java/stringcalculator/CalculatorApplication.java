package stringcalculator;

import stringcalculator.domain.StringCalculator;
import stringcalculator.view.InputView;
import stringcalculator.view.OutputView;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        String rawEquation = inputView.inputEquation();
        StringCalculator stringCalculator = StringCalculator.of(rawEquation);
        OutputView.printAnswer(stringCalculator.calculate());
    }
}
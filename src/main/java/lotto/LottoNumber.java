package lotto;

import java.util.Objects;

public class LottoNumber {

    final static int MIN_NUMBER = 1;
    final static int MAX_NUMBER = 45;

    private final int number;

    public LottoNumber(int number) {
        validation(number);
        this.number = number;
    }

    public static LottoNumber from(int number) {
        return new LottoNumber(number);
    }

    private void validation(int number) {
        if (number < MIN_NUMBER) {
            throw new IllegalArgumentException("로또의 숫자는 최소 1입니다.");
        }
        if (number > MAX_NUMBER) {
            throw new IllegalArgumentException("로또의 숫자는 최대 45입니다.");
        }
    }

    public boolean equalNumber(int compareInteger) {
        return this.number == compareInteger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

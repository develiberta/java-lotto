package lotto.domain;

import java.util.Objects;

public class Score {

	private static final int BONUS_AVAILABLE_SCORE = 5;

	private int score;
	private int bonusScore;

	public Score(int score, int bonusScore) {
		if (score < 0 || bonusScore < 0) {
			throw new IllegalArgumentException("점수나 보너스 점수는 음수일 수 없습니다.");
		}
		this.score = score;
		this.bonusScore = bonusScore;
	}

	// TC 작성을 수월하게 하기 위한 생성자, 프로덕션 코드에서 사용금지.
	public Score(int score) {
		if (score < 0) {
			throw new IllegalArgumentException("점수는 음수일 수 없습니다.");
		}
		this.score = score;
		this.bonusScore = 0;
	}

	public void plus() {
		this.score++;
	}

	public void plusBonus() {
		this.bonusScore++;
	}

	public boolean isBonusPossible() {
		return this.score == Score.BONUS_AVAILABLE_SCORE;
	}

	public boolean isMatchBonus() {
		return this.bonusScore > 0;
	}

	public boolean isScoreEquals(int score) {
		return this.score == score;
	}

	public int getScore() {
		return this.score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Score score1 = (Score)o;
		return score == score1.score && bonusScore == score1.bonusScore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(score, bonusScore);
	}
}
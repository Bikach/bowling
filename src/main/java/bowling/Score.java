package bowling;

import java.util.Objects;

public class Score {
    private int result;

    public Score(int result) {
        this.result = result;
    }

    public boolean isStrike() {
        return result == 10 && this instanceof StrikeScore;
    }

    public boolean isSpare() {
        return result == 10 && this instanceof SpareScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return result == score.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "Score{" +
                "result=" + result +
                '}';
    }

    public int getResult() {
        return result;
    }
}

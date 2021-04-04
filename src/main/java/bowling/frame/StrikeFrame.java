package bowling.frame;

import bowling.score.EmptyScore;
import bowling.score.Score;
import org.apache.commons.lang3.tuple.Pair;

public class StrikeFrame extends Frame {
    private final Score nextFirstScore;
    private final Score nextSecondScore;

    public StrikeFrame(Pair<Score, Score> nextScores, Frame lastFrame) {
        super( lastFrame, false);
        this.nextFirstScore = nextScores.getLeft();
        this.nextSecondScore = nextScores.getRight();
    }

    @Override
    public void computeResult() {
        this.result = lastFrame.getResult() +
                MAX_SCORE +
                nextFirstScore.getResult() +
                nextSecondScore.getResult();
        this.hasResultPresent = !(nextSecondScore instanceof EmptyScore);
    }

    @Override
    public String toString() {
        return "StrikeFrame{" +
                "result=" + result +
                ", hasResultPresent=" + hasResultPresent +
                ", lastFrame=" + lastFrame +
                ", nextFirstScore=" + nextFirstScore +
                ", nextSecondScore=" + nextSecondScore +
                '}';
    }
}

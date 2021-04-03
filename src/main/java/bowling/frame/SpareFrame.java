package bowling.frame;

import bowling.score.EmptyScore;
import bowling.score.Score;

public class SpareFrame extends Frame {

    private final Score nextScore;

    public SpareFrame(Score nextScore, Frame lastFrame) {
        super(lastFrame, false);
        this.nextScore = nextScore;
    }

    @Override
    public void computeResult() {
        this.result = lastFrame.getResult() +
                MAX_SCORE +
                nextScore.getResult();
        this.hasResultPresent = !(nextScore instanceof EmptyScore);
    }
}

package bowling.frame;

import bowling.score.Score;
import bowling.score.SpareScore;

public class SpareFrame extends Frame {

    public SpareFrame(Score score) {
        this.firstScore = score;
        this.secondScore = new SpareScore();
    }

    public int getValue() {
        return MAX_SCORE;
    }

    @Override
    public int computeResultFromLastClassicFrame(ClassicFrame lastFrame) {
        return lastFrame.getResult();
    }

    @Override
    public int computeResultFromLastStrikeFrame(StrikeFrame strikeFrame) {
        return 20;
    }
}

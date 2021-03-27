package bowling.frame;

import bowling.score.EmptyScore;
import bowling.score.StrikeScore;

public class StrikeFrame extends Frame {
    public StrikeFrame() {
        this.firstScore = new StrikeScore();
        this.secondScore = new EmptyScore();
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
        return 0;
    }
}

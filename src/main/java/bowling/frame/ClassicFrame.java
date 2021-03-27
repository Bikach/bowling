package bowling.frame;

import bowling.score.Score;

public class ClassicFrame extends Frame {
    public ClassicFrame(Score s1, Score s2) {
        this.firstScore = s1;
        this.secondScore = s2;
        this.result = s1.getResult() + s2.getResult();
    }

    @Override
    public int computeResultFromLastClassicFrame(ClassicFrame lastFrame) {
        return lastFrame.getResult() + this.getResult();
    }

    @Override
    public int computeResultFromLastStrikeFrame(StrikeFrame strikeFrame) {
        strikeFrame.addScoreToResult(strikeFrame.getValue() + this.result);
        return strikeFrame.getResult() + this.getResult();
    }
}

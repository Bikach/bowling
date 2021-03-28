package bowling.frame;

import bowling.score.Score;

public class Frame {
    protected Score firstScore;
    protected Score secondScore;
    protected Frame lastFrame;
    protected int result;
    protected boolean hasResultPresent;

    public Frame(Score firstScore, Score secondScore, Frame lastFrame, boolean hasResultPresent) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.lastFrame = lastFrame;
        this.hasResultPresent = hasResultPresent;
    }

    protected static final int MAX_SCORE = 10;

    public int getResult() {
        return result;
    }

    public void addScoreToResult(int resultToAdd) {
        this.result += resultToAdd;
    }

    public boolean hasResultPresent() {
        return hasResultPresent || result > 0;
    }

    @Override
    public String toString() {
        return "Frame{" +
                "firstScore=" + firstScore +
                ", secondScore=" + secondScore +
                ", result=" + result +
                '}';
    }
}

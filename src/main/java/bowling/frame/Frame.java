package bowling.frame;

import bowling.score.Score;

public abstract class Frame {
    protected Score firstScore;
    protected Score secondScore;
    protected int result;

    protected static final int MAX_SCORE = 10;

    public int getResult() {
        return result;
    }

    public void addScoreToResult(int result) {
        this.result += result;
    }

    public int computeResultFromLastFrame(Frame frame) {
        if(frame instanceof StrikeFrame) {
            return this.computeResultFromLastStrikeFrame((StrikeFrame) frame);
        }
        if(frame instanceof SpareFrame) {
            return this.computeResultFromLastSpareFrame((SpareFrame) frame);
        }

        return this.computeResultFromLastClassicFrame((ClassicFrame) frame);
    }

    public int computeResultFromLastSpareFrame(SpareFrame spareFrame) {
        spareFrame.addScoreToResult(spareFrame.getValue() + this.firstScore.getResult());
        return spareFrame.getResult() + this.getResult();
    }

    public abstract int computeResultFromLastClassicFrame(ClassicFrame lastFrame);
    public abstract int computeResultFromLastStrikeFrame(StrikeFrame strikeFrame);

    @Override
    public String toString() {
        return "Frame{" +
                "firstScore=" + firstScore +
                ", secondScore=" + secondScore +
                ", result=" + result +
                '}';
    }
}

package bowling.frame;

import bowling.score.Score;

public class ClassicFrame extends Frame {
    private final Score firstScore;
    private final Score secondScore;

    public ClassicFrame(Score firstScore, Score secondScore, Frame lastFrame) {
        super(lastFrame, true);
        this.firstScore = firstScore;
        this.secondScore = secondScore;
    }

    @Override
    public void computeResult() {
        this.result = lastFrame.getResult() +
                firstScore.getResult() +
                secondScore.getResult();
    }

    @Override
    public String toString() {
        return "ClassicFrame{" +
                "firstScore=" + firstScore +
                ", secondScore=" + secondScore +
                ", result=" + result +
                ", hasResultPresent=" + hasResultPresent +
                ", lastFrame=" + lastFrame +
                '}';
    }
}

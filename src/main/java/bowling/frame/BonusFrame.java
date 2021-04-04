package bowling.frame;

import bowling.score.Score;

import java.util.List;

public class BonusFrame extends Frame {

    private final List<Score> scores;

    public BonusFrame(List<Score> scores, Frame lastFrame) {
        super(lastFrame, true);
        this.scores = scores;
    }

    @Override
    public void computeResult() {
        this.result = scores.stream()
                .map(Score::getResult)
                .reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return "BonusFrame{" +
                "scores=" + scores +
                ", result=" + result +
                ", hasResultPresent=" + hasResultPresent +
                ", lastFrame=" + lastFrame +
                '}';
    }
}

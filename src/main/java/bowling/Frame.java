package bowling;

import bowling.score.EmptyScore;
import bowling.score.Score;
import bowling.score.SpareScore;
import bowling.score.StrikeScore;

public class Frame {
    private final Score firstScore;
    private final Score secondScore;
    private int result;

    public Frame(Score firstScore, Score secondScore) {
        this.firstScore = firstScore;
        this.secondScore = secondScore;
        this.result = firstScore.getResult() + secondScore.getResult();
    }

    public Frame(StrikeScore strikeScore) {
        this.firstScore = strikeScore;
        this.secondScore = new EmptyScore();
        this.result = 0;
    }

    public Frame(Score firstScore, SpareScore spareScore) {
        this.firstScore = firstScore;
        this.secondScore = spareScore;
        this.result = 0;
    }

    public int getResult() {
        return result;
    }

    public void addScoreToResult(int result) {
        this.result += result;
    }

    public int getResultFromFirstScore() {
        return this.firstScore.getResult();
    }

    public boolean isStrike() {
        return firstScore.isStrike();
    }

    public boolean isSpare() {
        return secondScore.isSpare();
    }

    public int computeResultFromLastFrame(Frame lastFrame) {
        if(this.result == 0) {
            return updateResult(lastFrame);
        }
        return this.result + updateResult(lastFrame);
    }

    private int updateResult(Frame lastFrame) {
        if(lastFrame.isSpare()) {
            lastFrame.addScoreToResult(this.getResultFromFirstScore() + 10);
        }
        if(lastFrame.isStrike()) {
            if(this.isSpare()) {
                lastFrame.addScoreToResult(10);
            }
            lastFrame.addScoreToResult(this.getResult() + 10);
        }
        return lastFrame.result;
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

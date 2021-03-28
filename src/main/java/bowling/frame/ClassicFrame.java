package bowling.frame;

import bowling.score.Score;

public class ClassicFrame extends Frame {
    public ClassicFrame(Score s1, Score s2, Frame lastFrame) {
        super(s1, s2, lastFrame, true);
        updateResult();
    }

    public void updateResult() {
        this.addScoreToResult(firstScore.getResult() + secondScore.getResult());
        if(lastFrame != null) {
            if(lastFrame instanceof StrikeFrame) {
                lastFrame.addScoreToResult(this.getResult() + MAX_SCORE);
            }
            if(lastFrame instanceof SpareFrame) {
                lastFrame.addScoreToResult(this.firstScore.getResult() + MAX_SCORE);
            }
            addScoreToResult(lastFrame.getResult());
        }
    }
}

package bowling.frame;

import bowling.score.Score;
import bowling.score.SpareScore;

public class SpareFrame extends Frame {

    public SpareFrame(Score score, Frame lastFrame) {
        super(score, new SpareScore(), lastFrame, false);
        updateResult();
    }

    public void updateResult() {
        if(lastFrame != null) {
            if(lastFrame instanceof StrikeFrame) {
                lastFrame.addScoreToResult(MAX_SCORE + MAX_SCORE);
            }
            if(lastFrame instanceof SpareFrame) {
                lastFrame.addScoreToResult(this.firstScore.getResult() + MAX_SCORE);
            }
        }
        this.result = 0;
    }
}

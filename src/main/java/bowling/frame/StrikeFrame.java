package bowling.frame;

import bowling.score.EmptyScore;
import bowling.score.StrikeScore;

public class StrikeFrame extends Frame {
    public StrikeFrame(Frame lastFrame) {
        super(new StrikeScore(), new EmptyScore(), lastFrame, false);
        updateResult();
    }

    public void updateResult() {
        if(lastFrame != null) {
            if(lastFrame instanceof StrikeFrame) {
                lastFrame.addScoreToResult(0);
                lastFrame.hasResultPresent = true;
            }
            if(lastFrame instanceof SpareFrame) {
                lastFrame.addScoreToResult(MAX_SCORE + MAX_SCORE);
            }
        }
        this.result = 0;
    }
}

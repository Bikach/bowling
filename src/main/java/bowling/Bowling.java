package bowling;

import bowling.frame.ClassicFrame;
import bowling.frame.Frame;
import bowling.frame.SpareFrame;
import bowling.frame.StrikeFrame;
import bowling.score.Score;
import bowling.score.ScoreBuilder;

public class Bowling {

    private static final char STRIKE = 'x';
    private static final char SPARE = '/';

    public int computeScoreInFrame(String firstFrame, String secondFrame) {
        Frame f1 = buildFrame(firstFrame);
        Frame f2 = buildFrame(secondFrame);
        Game game = new Game(f1, f2);

        return game.computeResult();
    }

    private Frame buildFrame(String frame) {
        char numberOfPinHitInFirstTrieInFrameOne = frame.charAt(0);
        char numberOfPinHitInSecondTrieInFrameOne = frame.charAt(1);
        if(STRIKE == numberOfPinHitInFirstTrieInFrameOne) {
            return new StrikeFrame();
        }

        Score s1 = ScoreBuilder.buildScore(numberOfPinHitInFirstTrieInFrameOne);
        if(SPARE == numberOfPinHitInSecondTrieInFrameOne) {
            return new SpareFrame(s1);
        }
        Score s2 = ScoreBuilder.buildScore(numberOfPinHitInSecondTrieInFrameOne);
        return new ClassicFrame(s1, s2);
    }


}

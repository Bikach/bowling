package bowling;

import bowling.frame.ClassicFrame;
import bowling.frame.Frame;
import bowling.frame.SpareFrame;
import bowling.frame.StrikeFrame;
import bowling.score.Score;
import bowling.score.ScoreBuilder;
import org.apache.commons.lang3.StringUtils;

public class Bowling {

    private static final char STRIKE = 'x';
    private static final char SPARE = '/';

    public int computeScoreInFrame(String party) {
        Game game = new Game();
        Frame lastFrame = null;
        int nbFrame = StringUtils.countMatches(party, '|');
        String[] frames = party.split("\\|", nbFrame);
        for(String frameString : frames) {
            Frame actualFrame = buildFrame(frameString, lastFrame);
            game.addFrame(actualFrame);
            lastFrame = actualFrame;
        }

        return game.computeResult();
    }

    private Frame buildFrame(String frame, Frame lastFrame) {
        char numberOfPinHitInFirstTrieInFrameOne = frame.charAt(0);
        if(STRIKE == numberOfPinHitInFirstTrieInFrameOne) {
            return new StrikeFrame(lastFrame);
        }

        Score firstScore = ScoreBuilder.buildScore(numberOfPinHitInFirstTrieInFrameOne);
        char numberOfPinHitInSecondTrieInFrameOne = frame.charAt(1);
        if(SPARE == numberOfPinHitInSecondTrieInFrameOne) {
            return new SpareFrame(firstScore, lastFrame);
        }
        Score secondScore = ScoreBuilder.buildScore(numberOfPinHitInSecondTrieInFrameOne);
        return new ClassicFrame(firstScore, secondScore, lastFrame);
    }


}

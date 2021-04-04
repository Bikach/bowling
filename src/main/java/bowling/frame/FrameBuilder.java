package bowling.frame;

import bowling.score.Score;
import bowling.score.ScoreScanner;
import bowling.score.SpareScore;
import bowling.score.StrikeScore;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FrameBuilder {
    private static final char CHAR_DELIMITER = '|';
    private static final String FRAME_BOUNDARY = "\\" + CHAR_DELIMITER;

    private FrameBuilder() {
    }

    public static String[] splitPartyToFrames(String party) {
        int nbFrame = StringUtils.countMatches(party, CHAR_DELIMITER);
        return party.split(FRAME_BOUNDARY, nbFrame);
    }

    public static List<Frame> buildFrames(ScoreScanner scoreScanner) {
        LinkedList<Frame> frames = new LinkedList<>(Collections.singletonList(new EmptyFrame()));
        LinkedList<Score> scores = scoreScanner.getScores();

        while(scoreScanner.hasScoresNotEmpty()) {
            Frame lastFrame = frames.getLast();
            if(scoreScanner.haveBonus()) {
                frames.add(new BonusFrame(scores, lastFrame));
                break;
            } else {
                Score firstScore = scores.removeFirst();
                if(firstScore instanceof StrikeScore) {
                    frames.add(new StrikeFrame(scoreScanner.retrieveTwoNextScore(), lastFrame));
                    continue;
                }

                Score secondScore = scores.removeFirst();
                if(secondScore instanceof SpareScore) {
                    frames.add(new SpareFrame(scoreScanner.retrieveNextScore(), lastFrame));
                } else {
                    frames.add(new ClassicFrame(firstScore, secondScore, lastFrame));
                }
            }

        }
        return frames;
    }
}

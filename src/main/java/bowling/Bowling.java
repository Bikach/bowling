package bowling;

import bowling.frame.*;
import bowling.score.Score;
import bowling.score.ScoreScanner;
import bowling.score.SpareScore;
import bowling.score.StrikeScore;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Bowling {

    private final ScoreScanner scoreScanner = new ScoreScanner();

    public int computeScoreBowling(String party) {
        Game game = buildGame(party);
        return game.computeResult();
    }

    private Game buildGame(String party) {
        scoreScanner.scanParty(party);

        return new Game(buildFrames());
    }

    private List<Frame> buildFrames() {
        LinkedList<Frame> frames = new LinkedList<>(Collections.singletonList(new EmptyFrame()));
        LinkedList<Score> scores = scoreScanner.getScores();

        while(scoreScanner.hasScoresNotEmpty()) {
            Frame lastFrame = frames.getLast();
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
        return frames;
    }
}

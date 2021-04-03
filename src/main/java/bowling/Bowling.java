package bowling;

import bowling.frame.FrameBuilder;
import bowling.score.ScoreScanner;

public class Bowling {

    private final ScoreScanner scoreScanner = new ScoreScanner();

    public int computeScoreBowling(String party) {
        Game game = buildGame(party);
        return game.computeResult();
    }

    private Game buildGame(String party) {
        scoreScanner.scanParty(party);

        return new Game(FrameBuilder.buildFrames(scoreScanner));
    }

}

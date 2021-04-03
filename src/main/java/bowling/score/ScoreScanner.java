package bowling.score;

import bowling.frame.*;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;

public class ScoreScanner {
    private static final char STRIKE = 'x';
    private static final char SPARE = '/';
    private final LinkedList<Score> scores;

    public ScoreScanner() {
        scores = new LinkedList<>();
    }


    public void scanParty(String party) {
        String[] frames = FrameBuilder.splitPartyToFrames(party);
        for(String frameString : frames) {
            fillScores(frameString);
        }
    }

    private void fillScores(String frameString) {
        char numberOfPinHitInFirstTrieInFrameOne = frameString.charAt(0);
        if(STRIKE == numberOfPinHitInFirstTrieInFrameOne) {
            scores.add(new StrikeScore());
            return;
        }
        char numberOfPinHitInSecondTrieInFrameOne = frameString.charAt(1);
        scores.add(ScoreBuilder.buildScore(numberOfPinHitInFirstTrieInFrameOne));
        if(SPARE == numberOfPinHitInSecondTrieInFrameOne) {
            scores.add(new SpareScore(10 - scores.getLast().getResult()));
            return;
        }
        scores.add(ScoreBuilder.buildScore(numberOfPinHitInSecondTrieInFrameOne));
    }

    public LinkedList<Score> getScores() {
        return scores;
    }

    public boolean hasScoresNotEmpty() {
        return !scores.isEmpty();
    }

    public Score retrieveNextScore() {
        if(scores.isEmpty()) {
            return new EmptyScore();
        }
        return scores.getFirst();
    }

    public Pair<Score, Score> retrieveTwoNextScore() {
        if(scores.isEmpty()) {
            return Pair.of(new EmptyScore(), new EmptyScore());
        }
        if(scores.size() == 1) {
            return Pair.of(scores.getFirst(), new EmptyScore());
        }
        return Pair.of(scores.get(0), scores.get(1));
    }
}

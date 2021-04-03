package bowling.score;

public class ScoreBuilder {

    private ScoreBuilder() {
    }

    private static final char STRIKE = 'x';
    private static final char MISSED = '-';

    public static Score buildScore(char numberOfPinHit) {
        return new Score(computeScoreDuringTryout(numberOfPinHit));
    }

    private static int computeScoreDuringTryout(char numberOfPinHit) {
        if(STRIKE == numberOfPinHit) {
            return 10;
        }
        else if(MISSED == numberOfPinHit) {
            return 0;
        }
        return Character.getNumericValue(numberOfPinHit);
    }
}

package bowling;

public class Bowling {

    private static final char STRIKE = 'x';
    private static final char MISSED = '-';
    private static final char SPARE = '/';

    public int computeScoreInFrame(String frame) {
        char numberOfPinHitInFirstTrie = frame.charAt(0);
        char numberOfPinHitInSecondTrie = frame.charAt(1);
        if(STRIKE == numberOfPinHitInFirstTrie) {
            return 10;
        }
        if(SPARE == numberOfPinHitInSecondTrie) {
            return 10;
        }
        return computeScore(numberOfPinHitInFirstTrie) + computeScore(numberOfPinHitInSecondTrie);
    }

    private int computeScore(char numberOfPinHit) {
        if(STRIKE == numberOfPinHit) {
            return 10;
        }
        else if(MISSED == numberOfPinHit) {
            return 0;
        }
       return Character.getNumericValue(numberOfPinHit);
    }
}

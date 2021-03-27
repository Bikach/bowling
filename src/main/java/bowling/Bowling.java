package bowling;

public class Bowling {

    private static final char STRIKE = 'x';
    private static final char MISSED = '-';
    private static final char SPARE = '/';

    public Score computeScoreInFrame(String firstFrame, String secondFrame) {
        return new Score(computeScoreDuringFrame(firstFrame) + computeScoreDuringFrame(secondFrame));
    }

    private Integer computeScoreDuringFrame(String frame) {
        char numberOfPinHitInFirstTrieInFrameOne = frame.charAt(0);
        char numberOfPinHitInSecondTrieInFrameOne = frame.charAt(1);
        if(STRIKE == numberOfPinHitInFirstTrieInFrameOne || SPARE == numberOfPinHitInSecondTrieInFrameOne) {
            return 10;
        }
        return computeScoreDuringTryout(numberOfPinHitInFirstTrieInFrameOne) + computeScoreDuringTryout(numberOfPinHitInSecondTrieInFrameOne);
    }

    private int computeScoreDuringTryout(char numberOfPinHit) {
        if(STRIKE == numberOfPinHit) {
            return 10;
        }
        else if(MISSED == numberOfPinHit) {
            return 0;
        }
       return Character.getNumericValue(numberOfPinHit);
    }
}

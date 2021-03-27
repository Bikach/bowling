package bowling;

public class Bowling {

    private static final char STRIKE = 'x';
    private static final char MISSED = '-';
    private static final char SPARE = '/';

    public Score computeScoreInFrame(String firstFrame, String secondFrame) {
        Score scoreDuringFistFrame = computeScoreDuringFrame(firstFrame);
        Score scoreDuringSecondFrame = computeScoreDuringFrame(secondFrame);
        if(scoreDuringFistFrame.isSpare() && scoreDuringSecondFrame.isStrike()) {
            return new Score(scoreDuringFistFrame.getResult() + scoreDuringSecondFrame.getResult());
        }

        Score newScoreDuringFistFrame = computeNewScore(scoreDuringFistFrame, secondFrame.charAt(0), scoreDuringSecondFrame.getResult());

        return mergeScore(newScoreDuringFistFrame, scoreDuringSecondFrame);
    }

    private Score computeNewScore(Score scoreDuringFistFrame, final char numberOfPinHit, final int result) {
        if(scoreDuringFistFrame.isSpare()) {
            scoreDuringFistFrame.addResult(computeScoreDuringTryout(numberOfPinHit));
        }
        else if(scoreDuringFistFrame.isStrike()) {
            scoreDuringFistFrame.addResult(result);
        }

        return new Score(scoreDuringFistFrame.getResult());
    }

    private Score mergeScore(Score firstScore, Score secondScore) {
        return new Score(firstScore.getResult() + secondScore.getResult());
    }

    private Score computeScoreDuringFrame(String frame) {
        char numberOfPinHitInFirstTrieInFrameOne = frame.charAt(0);
        char numberOfPinHitInSecondTrieInFrameOne = frame.charAt(1);
        if(STRIKE == numberOfPinHitInFirstTrieInFrameOne) {
            return new StrikeScore();
        }
        if(SPARE == numberOfPinHitInSecondTrieInFrameOne) {
            return new SpareScore();
        }
        return new Score(computeScoreDuringTryout(numberOfPinHitInFirstTrieInFrameOne) + computeScoreDuringTryout(numberOfPinHitInSecondTrieInFrameOne));
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

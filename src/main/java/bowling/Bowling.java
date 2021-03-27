package bowling;

public class Bowling {

    private static final String STRIKE = "x";
    private static final String MISSED = "-";
    private static final String SPARE = "/";

    public int computeScore(String numberOfPinHitInFirstTrie, String numberOfPinHitInSecondTrie) {
        if(SPARE.equals(numberOfPinHitInSecondTrie)) {
            return 10;
        }
        return computeScore(numberOfPinHitInFirstTrie) + computeScore(numberOfPinHitInSecondTrie);
    }

    public int computeScore(String numberOfPinHit) {
        if(STRIKE.equals(numberOfPinHit)) {
            return 10;
        }
        else if(MISSED.equals(numberOfPinHit)) {
            return 0;
        }
       return Integer.parseInt(numberOfPinHit);
    }
}

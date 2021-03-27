package bowling;

public class Bowling {

    private static final String STRIKE = "x";
    private static final String MISSED = "-";

    public int computeScore(String numberOfPinHit) {
        if(STRIKE.equals(numberOfPinHit)) {
            return 10;
        }
        if(MISSED.equals(numberOfPinHit)) {
            return 0;
        }
        return Integer.parseInt(numberOfPinHit);
    }
}

package Bowling;

public class Bowling {

    private static final String FRAME_BOUNDARY = "\\|";
    private static final String MISS_INDICATOR = "-";
    private static final String NULL_SCORE = "0";

    private static final int FIRST_TRIAL = 0;
    private static final int SECOND_TRIAL = 1;

    public int score(String bowlingGame) {
        var frames = bowlingGame.replace(MISS_INDICATOR, NULL_SCORE).split(FRAME_BOUNDARY);
        return computeScore(frames);
    }

    private int computeScore(String[] frames) {
        var result = 0;
        for (String frame: frames) {
            var tries = frame.split("");
            result += Integer.parseInt(tries[FIRST_TRIAL]) + Integer.parseInt(tries[SECOND_TRIAL]);
        }
        return result;
    }
}

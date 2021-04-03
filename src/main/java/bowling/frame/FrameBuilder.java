package bowling.frame;

import org.apache.commons.lang3.StringUtils;

public class FrameBuilder {
    private static final char CHAR_DELIMITER = '|';
    private static final String FRAME_BOUNDARY = "\\" + CHAR_DELIMITER;

    private FrameBuilder() {
    }

    public static String[] splitPartyToFrames(String party) {
        int nbFrame = StringUtils.countMatches(party, CHAR_DELIMITER);
        return party.split(FRAME_BOUNDARY, nbFrame);
    }
}

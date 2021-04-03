package bowling;

import bowling.frame.Frame;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private final List<Frame> frames;

    public Game(List<Frame> frames) {
        this.frames = frames;
    }

    public int computeResult() {
        frames.forEach(Frame::computeResult);

        if(hasResultInFrames()) {
            return frames.stream()
                    .filter(Frame::hasResultPresent)
                    .collect(Collectors.toCollection(LinkedList::new))
                    .removeLast().getResult();
        }

        return 0;
    }

    private boolean hasResultInFrames() {
        return frames.stream().anyMatch(Frame::hasResultPresent);
    }
}

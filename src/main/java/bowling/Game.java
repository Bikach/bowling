package bowling;

import bowling.frame.Frame;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class Game {

    private final LinkedList<Frame> frames;

    public Game() {
        this.frames = new LinkedList<>();
    }

    public void addFrame(Frame frame) {
        frames.add(frame);
    }

    public int computeResult() {
        return frames.stream()
                .filter(Frame::hasResultPresent)
                .collect(Collectors.toCollection(LinkedList::new))
                .removeLast().getResult();
    }
}

package bowling;

import bowling.frame.Frame;

public class Game {

    private final Frame firstFrame;
    private final Frame secondFrame;

    public Game(Frame firstFrame, Frame secondFrame) {
        this.firstFrame = firstFrame;
        this.secondFrame = secondFrame;
    }

    public int computeResult() {
        return secondFrame.computeResultFromLastFrame(firstFrame);
    }
}

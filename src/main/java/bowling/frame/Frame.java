package bowling.frame;

public abstract class Frame {
    protected int result;
    protected boolean hasResultPresent;
    protected Frame lastFrame;

    protected Frame(Frame lastFrame, boolean hasResultPresent) {
        this.lastFrame = lastFrame;
        this.hasResultPresent = hasResultPresent;
    }

    protected static final int MAX_SCORE = 10;

    public int getResult() {
        return result;
    }

    public boolean hasResultPresent() {
        return hasResultPresent;
    }

    public abstract void computeResult();

    @Override
    public String toString() {
        return "Frame{" +
                ", result=" + result +
                ", hasResultPresent=" + hasResultPresent +
                '}';
    }
}

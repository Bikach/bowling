package bowling.frame;

public class EmptyFrame extends Frame {
    public EmptyFrame() {
        super( null, false);
    }

    @Override
    public void computeResult() {
        this.result = 0;
    }
}

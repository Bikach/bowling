import bowling.Bowling;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingTest {

    private final Bowling bowling = new Bowling();

    @Test
    void should_return_1_when_one_pin_hit() {
        assertThat(bowling.computeScore("1")).isEqualTo(1);
    }

    @Test
    void should_return_2_when_two_pins_hit() {
        assertThat(bowling.computeScore("2")).isEqualTo(2);
    }

    @Test
    void should_return_10_when_have_strike() {
        assertThat(bowling.computeScore("x")).isEqualTo(10);
    }

    @Test
    void should_return_0_when_missed() {
        assertThat(bowling.computeScore("-")).isZero();
    }

}

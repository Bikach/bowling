import bowling.Bowling;
import bowling.Score;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingTest {

    private final Bowling bowling = new Bowling();

    @Nested
    class SecondTryMissed {
        @Test
        void should_return_1_when_one_pin_hit() {
            assertThat(bowling.computeScoreInFrame("1-|", "--|")).isEqualTo(new Score(1));
        }

        @Test
        void should_return_2_when_two_pins_hit() {
            assertThat(bowling.computeScoreInFrame("2-|", "--|")).isEqualTo(new Score(2));
        }

        @Test
        void should_return_0_when_missed() {
            assertThat(bowling.computeScoreInFrame("--|", "--|")).isEqualTo(new Score(0));
        }
    }

    @Nested
    class SecondTrySuccessful {

        @Test
        void should_return_2_when_two_pin_hit_after_two_try() {
            assertThat(bowling.computeScoreInFrame("11|", "--|")).isEqualTo(new Score(2));
            assertThat(bowling.computeScoreInFrame("-2|", "--|")).isEqualTo(new Score(2));
        }

        @Test
        void should_return_10_when_spare_in_second_try() {
            assertThat(bowling.computeScoreInFrame("1/|", "--|")).isEqualTo(new Score(10));
            assertThat(bowling.computeScoreInFrame("1/|", "--|")).isEqualTo(new Score(10));
            assertThat(bowling.computeScoreInFrame("-/|", "--|")).isEqualTo(new Score(10));
        }

    }

    @Nested
    class StrikeInFirstTry {
        @Test
        void should_return_10_when_strike_to_first_try() {
            assertThat(bowling.computeScoreInFrame("x|", "--|")).isEqualTo(new Score(10));
        }
    }

    @Nested
    class TwoFrame {
        @Test
        void should_return_5_when_first_frame_result_was_3_and_second_frame_result_was_2() {
            assertThat(bowling.computeScoreInFrame("12|", "11|")).isEqualTo(new Score(5));
        }
    }

}

import bowling.Bowling;
import bowling.Score;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingTest {

    private final Bowling bowling = new Bowling();

    @Nested
    class SecondFrameMissed {
        @Nested
        class SecondTryMissed {
            @Test
            void should_return_1_when_one_pin_hit() {
                assertThat(bowling.computeScoreInFrame("1-|", "--|")).isEqualTo(1);
            }

            @Test
            void should_return_2_when_two_pins_hit() {
                assertThat(bowling.computeScoreInFrame("2-|", "--|")).isEqualTo(2);
            }

            @Test
            void should_return_0_when_missed() {
                assertThat(bowling.computeScoreInFrame("--|", "--|")).isZero();
            }
        }

        @Nested
        class SecondTrySuccessful {

            @Test
            void should_return_2_when_two_pin_hit_after_two_try() {
                assertThat(bowling.computeScoreInFrame("11|", "--|")).isEqualTo(2);
            }

            @Test
            void should_return_10_when_spare_in_second_try() {
                assertThat(bowling.computeScoreInFrame("1/|", "--|")).isEqualTo(10);
            }

        }

        @Nested
        class StrikeInFirstTry {
            @Test
            void should_return_10_when_strike_to_first_try() {
                assertThat(bowling.computeScoreInFrame("x|", "--|")).isEqualTo(10);
            }

        }
    }

    @Nested
    class SecondFrameSuccessful {

        @Test
        void should_return_5_when_first_frame_result_was_3_and_second_frame_result_was_2() {
            assertThat(bowling.computeScoreInFrame("12|", "11|")).isEqualTo(5);
        }

        @Nested
        class StrikeInFirstTry {

            @Test
            void should_return_14_when__second_frame_result_was_2() {
                assertThat(bowling.computeScoreInFrame("x|", "11|")).isEqualTo(14);
            }
        }

        @Nested
        class SpareInFirstTry {
            @Test
            void should_return_13_when_second_frame_result_was_missed() {
                assertThat(bowling.computeScoreInFrame("1/|", "2-|")).isEqualTo(14);
            }

            @Test
            void should_return_20_when_second_frame_is_strike() {
                assertThat(bowling.computeScoreInFrame("2/|", "x|")).isEqualTo(20);
            }

        }
    }

}

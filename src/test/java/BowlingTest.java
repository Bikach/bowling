import bowling.Bowling;
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

        @Nested
        class ClassicInFirstFrame {

            @Test
            void should_return_5_when_first_frame_result_is_3_and_second_frame_result_is_2() {
                assertThat(bowling.computeScoreInFrame("12|", "11|")).isEqualTo(5);
            }

            @Test
            void should_return_2_when_second_frame_result_is_strike() {
                assertThat(bowling.computeScoreInFrame("11|", "x|")).isEqualTo(2);
            }

            @Test
            void should_return_2_when_second_frame_result_is_spare() {
                assertThat(bowling.computeScoreInFrame("11|", "1/|")).isEqualTo(2);
            }

        }

        @Nested
        class StrikeInFirstFrame {

            @Test
            void should_return_14_when_second_frame_result_is_2() {
                assertThat(bowling.computeScoreInFrame("x|", "11|")).isEqualTo(14);
            }

            @Test
            void should_return_20_when_second_frame_is_spare() {
                assertThat(bowling.computeScoreInFrame("x|", "1/|")).isEqualTo(20);
            }

            @Test
            void should_return_20_when_second_frame_is_strike() {
                assertThat(bowling.computeScoreInFrame("x|", "x|")).isZero();
            }
        }

        @Nested
        class SpareInFirstFrame {
            @Test
            void should_return_13_when_second_frame_result_is_missed() {
                assertThat(bowling.computeScoreInFrame("1/|", "2-|")).isEqualTo(14);
            }

            @Test
            void should_return_20_when_second_frame_is_strike() {
                assertThat(bowling.computeScoreInFrame("2/|", "x|")).isEqualTo(20);
            }

            @Test
            void should_return_12_when_second_frame_is_spare() {
                assertThat(bowling.computeScoreInFrame("1/|", "2/|")).isEqualTo(12);
            }

            @Test
            void should_return_17_when_second_frame_result_is_not_missed() {
                assertThat(bowling.computeScoreInFrame("1/|", "23|")).isEqualTo(17);
            }

        }
    }

}

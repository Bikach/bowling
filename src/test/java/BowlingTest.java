import bowling.Bowling;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingTest {

    private final Bowling bowling = new Bowling();

    @Nested
    class OneFrame {
        @Test
        void should_return_1_when_one_pin_hit() {
            assertThat(bowling.computeScoreBowling("1-|")).isEqualTo(1);
        }
    }

    @Nested
    class TwoFrames {

        @Nested
        class SecondFrameSuccessful {

            @Nested
            class ClassicInFirstFrame {
                @Test
                void should_return_5_when_first_frame_result_is_3_and_second_frame_result_is_2() {
                    assertThat(bowling.computeScoreBowling("12|11|")).isEqualTo(5);
                }

                @Test
                void should_return_2_when_second_frame_result_is_strike() {
                    assertThat(bowling.computeScoreBowling("11|x|")).isEqualTo(2);
                }

                @Test
                void should_return_2_when_second_frame_result_is_spare() {
                    assertThat(bowling.computeScoreBowling("11|1/|")).isEqualTo(2);
                }
            }

            @Nested
            class StrikeInFirstFrame {
                @Test
                void should_return_14_when_second_frame_result_is_2() {
                    assertThat(bowling.computeScoreBowling("x|11|")).isEqualTo(14);
                }

                @Test
                void should_return_20_when_second_frame_is_spare() {
                    assertThat(bowling.computeScoreBowling("x|1/|")).isEqualTo(20);
                }

                @Test
                void should_return_20_when_second_frame_is_strike() {
                    assertThat(bowling.computeScoreBowling("x|x|")).isZero();
                }
            }

            @Nested
            class SpareInFirstFrame {
                @Test
                void should_return_13_when_second_frame_result_is_missed() {
                    assertThat(bowling.computeScoreBowling("1/|2-|")).isEqualTo(14);
                }

                @Test
                void should_return_20_when_second_frame_is_strike() {
                    assertThat(bowling.computeScoreBowling("2/|x|")).isEqualTo(20);
                }

                @Test
                void should_return_12_when_second_frame_is_spare() {
                    assertThat(bowling.computeScoreBowling("1/|2/|")).isEqualTo(12);
                }

                @Test
                void should_return_17_when_second_frame_result_is_not_missed() {
                    assertThat(bowling.computeScoreBowling("1/|23|")).isEqualTo(17);
                }
            }
        }

        @Nested
        class SecondFrameMissed {
            @Nested
            class SecondTryMissed {
                @Test
                void should_return_1_when_one_pin_hit() {
                    assertThat(bowling.computeScoreBowling("1-|--|")).isEqualTo(1);
                }

                @Test
                void should_return_2_when_two_pins_hit() {
                    assertThat(bowling.computeScoreBowling("2-|--|")).isEqualTo(2);
                }

                @Test
                void should_return_0_when_missed() {
                    assertThat(bowling.computeScoreBowling("--|--|")).isZero();
                }
            }

            @Nested
            class SecondTrySuccessful {

                @Test
                void should_return_2_when_two_pin_hit_after_two_try() {
                    assertThat(bowling.computeScoreBowling("11|--|")).isEqualTo(2);
                }

                @Test
                void should_return_10_when_spare_in_second_try() {
                    assertThat(bowling.computeScoreBowling("1/|--|")).isEqualTo(10);
                }

            }

            @Nested
            class StrikeInFirstTry {
                @Test
                void should_return_10_when_strike_to_first_try() {
                    assertThat(bowling.computeScoreBowling("x|--|")).isEqualTo(10);
                }

            }
        }
    }

    @Nested
    class ThreeFrames {
        @Test
        void should_return_6_when_at_each_frame_we_have_result_equal_to_2() {
            assertThat(bowling.computeScoreBowling("11|11|2-|")).isEqualTo(6);
        }

        @Test
        void should_return_30_when_all_frames_is_strike() {
            assertThat(bowling.computeScoreBowling("x|x|x|")).isEqualTo(30);
        }
    }

}

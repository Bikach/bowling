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
            assertThat(bowling.computeBowlingScore("1-|")).isEqualTo(1);
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
                    assertThat(bowling.computeBowlingScore("12|11|")).isEqualTo(5);
                }

                @Test
                void should_return_2_when_second_frame_result_is_strike() {
                    assertThat(bowling.computeBowlingScore("11|x|")).isEqualTo(2);
                }

                @Test
                void should_return_2_when_second_frame_result_is_spare() {
                    assertThat(bowling.computeBowlingScore("11|1/|")).isEqualTo(2);
                }
            }

            @Nested
            class StrikeInFirstFrame {
                @Test
                void should_return_14_when_second_frame_result_is_2() {
                    assertThat(bowling.computeBowlingScore("x|11|")).isEqualTo(14);
                }

                @Test
                void should_return_20_when_second_frame_is_spare() {
                    assertThat(bowling.computeBowlingScore("x|1/|")).isEqualTo(20);
                }

                @Test
                void should_return_20_when_second_frame_is_strike() {
                    assertThat(bowling.computeBowlingScore("x|x|")).isZero();
                }
            }

            @Nested
            class SpareInFirstFrame {
                @Test
                void should_return_13_when_second_frame_result_is_missed() {
                    assertThat(bowling.computeBowlingScore("1/|2-|")).isEqualTo(14);
                }

                @Test
                void should_return_20_when_second_frame_is_strike() {
                    assertThat(bowling.computeBowlingScore("2/|x|")).isEqualTo(20);
                }

                @Test
                void should_return_12_when_second_frame_is_spare() {
                    assertThat(bowling.computeBowlingScore("1/|2/|")).isEqualTo(12);
                }

                @Test
                void should_return_17_when_second_frame_result_is_not_missed() {
                    assertThat(bowling.computeBowlingScore("1/|23|")).isEqualTo(17);
                }
            }
        }

        @Nested
        class SecondFrameMissed {
            @Nested
            class SecondTryMissed {
                @Test
                void should_return_1_when_one_pin_hit() {
                    assertThat(bowling.computeBowlingScore("1-|--|")).isEqualTo(1);
                }

                @Test
                void should_return_2_when_two_pins_hit() {
                    assertThat(bowling.computeBowlingScore("2-|--|")).isEqualTo(2);
                }

                @Test
                void should_return_0_when_missed() {
                    assertThat(bowling.computeBowlingScore("--|--|")).isZero();
                }
            }

            @Nested
            class SecondTrySuccessful {

                @Test
                void should_return_2_when_two_pin_hit_after_two_try() {
                    assertThat(bowling.computeBowlingScore("11|--|")).isEqualTo(2);
                }

                @Test
                void should_return_10_when_spare_in_second_try() {
                    assertThat(bowling.computeBowlingScore("1/|--|")).isEqualTo(10);
                }

            }

            @Nested
            class StrikeInFirstTry {
                @Test
                void should_return_10_when_strike_to_first_try() {
                    assertThat(bowling.computeBowlingScore("x|--|")).isEqualTo(10);
                }

            }
        }
    }

    @Nested
    class ThreeFrames {
        @Test
        void should_return_6_when_at_each_frame_we_have_result_equal_to_2() {
            assertThat(bowling.computeBowlingScore("11|11|2-|")).isEqualTo(6);
        }

        @Test
        void should_return_30_when_all_frames_is_strike() {
            assertThat(bowling.computeBowlingScore("x|x|x|")).isEqualTo(30);
        }
    }

    @Nested
    class HandleBonus {
        @Test
        void should_return_10_when_in_bonus_we_have_spare_and_one_miss() {
            //assertThat(bowling.computeScoreBowling("11|11|11|11|11|11|11|11|11|9/-|")).isEqualTo(28);
            assertThat(bowling.computeBowlingScore("9/-|")).isEqualTo(10);
        }

    }

}

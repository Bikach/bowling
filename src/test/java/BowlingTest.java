import Bowling.Bowling;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BowlingTest {

    private final Bowling bowling = new Bowling();

    @Test
    void shouldHaveAScoreEqualsToZeroWhenFramesAreMissing() {
        var totallyFailedGame = "--|--|--|--|--|--|--|--|--|--";

        var score = bowling.score(totallyFailedGame);

        assertThat(score).isZero();
    }

    @Test
    void shouldHaveAScoreEqualsToOneWhenOnlyOnePinKnocksDown() {
        var onePinKnockDown = "1-|--|--|--|--|--|--|--|--|--";

        var score = bowling.score(onePinKnockDown);

        assertThat(score).isEqualTo(1);
    }

    @Test
    void shouldHaveAScoreEqualsToSixWhenSixPinsKnockDown() {
        var sixPinsKnockDown = "1-|--|--|--|5-|--|--|--|--|--";

        var score = bowling.score(sixPinsKnockDown);

        assertThat(score).isEqualTo(6);
    }

    @Test
    void shouldHaveAScoreEqualsToFifteenWhenFifteenPinsKnockDown() {
        var fifteenPinsKnockDown = "1-|--|--|--|5-|--|--|--|--|9-";

        var score = bowling.score(fifteenPinsKnockDown);

        assertThat(score).isEqualTo(15);
    }

}

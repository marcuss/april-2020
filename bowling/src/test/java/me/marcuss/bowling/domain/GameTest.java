package me.marcuss.bowling.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    public void setup() {
        game = new Game();
    }

    @Test
    public void canScoreWorstGame() {
        rollHelper(20, 0);
        assertThat(
                game.score(),
                is(0)
        );
    }

    @Test
    public void canScoreAllOnes() {
        rollHelper(20, 1);
        assertThat(
                game.score(),
                is(20)
        );
    }

    @Test
    public void canScoreAll3() {
        rollHelper(20, 3);
        assertThat(
                game.score(),
                is(60)
        );
    }

    @Test
    public void canScoreStartingWithSpare() {
        rollASpare();

        game.roll(6);
        game.roll(1);

        rollHelper(16, 1);

        assertThat(
                game.score(),
                is(16 + 7 + 16)
        );
    }

    @Test
    public void canScoreEndingWithSpare() {
        rollHelper(18, 1);
        rollASpare();
        game.roll(1);
        assertThat(
                game.score(),
                is(18 + 11)
        );
    }

    @Test
    public void canScoreStartingWithAStrike() {
        rollAStrike();
        game.roll(5);
        game.roll(3);
        rollHelper(16, 1);
        assertThat(
                game.score(),
                is(18 + 8 + 16)
        );
    }

    @Test
    public void canScoreEndingWithStrike() {
        rollHelper(18, 1);
        rollAStrike();
        game.roll(5);
        game.roll(4);
        assertThat(
                game.score(),
                is(18 + 19)
        );
    }

    @Test
    public void canScorePerfectGame() {
        rollHelper(12,10);
        assertThat(
                game.score(),
                is(300)
        );
    }

    @Test
    public void canScoreAllSpares() {
        rollHelper(21,5);
        assertThat(
                game.score(),
                is(150)
        );
    }

    @Test
    public void shouldThrowExceptionOnExtraRollsInAllSparesGame() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rollHelper(22,5);
        });
    }

    @Test
    public void shouldThrowExceptionOnExtraRollInPerfectGame() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            rollHelper(13,10);
        });
    }

    private void rollAStrike() {
        game.roll(10);
    }

    private void rollASpare() {
        game.roll(5);
        game.roll(5);
    }

    private void rollHelper(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

}
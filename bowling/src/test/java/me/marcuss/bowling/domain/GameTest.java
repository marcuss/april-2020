package me.marcuss.bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    public void stup() {
        game = new Game();
    }

    @Test
    public void canRoll() {
        game.roll(0);
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

    private void rollHelper(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }

}
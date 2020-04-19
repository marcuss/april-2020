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
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertThat(
                game.score(),
                is(0)
        );
    }

}
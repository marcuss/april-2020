package me.marcuss.bowling;

import me.marcuss.bowling.domain.Game;

public class AbstractGameTest {
    protected Game game;

    protected void rollAStrike() {
        game.roll(10);
    }

    protected void rollASpare() {
        game.roll(5);
        game.roll(5);
    }

    protected void rollHelper(int n, int pins) {
        for (int i = 0; i < n; i++) {
            game.roll(pins);
        }
    }
}

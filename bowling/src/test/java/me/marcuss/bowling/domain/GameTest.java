package me.marcuss.bowling.domain;

import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void canRoll() {
        Game game = new Game();
        game.roll(0);
    }

}
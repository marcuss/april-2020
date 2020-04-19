package me.marcuss.bowling.domain;

import java.util.Arrays;

public class Game {
    private Turn turns[];

    public Game() {
        turns = new Turn[10];
        for (int i = 0; i < turns.length - 1; i++) {
            turns[i] = new Turn();
        }
        turns[turns.length - 1] = new TenthTurn();
    }

    public Turn[] getTurns() {
        return turns;
    }

    public void setTurns(Turn[] turns) {
        this.turns = turns;
    }

    @Override
    public String toString() {
        return "Game{" +
                "turns=" + Arrays.toString(turns) +
                '}';
    }

    public void roll(int i) {
    }
}

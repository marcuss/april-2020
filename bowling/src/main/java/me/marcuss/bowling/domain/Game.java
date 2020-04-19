package me.marcuss.bowling.domain;

public class Game {
    private Turn turns[];

    public Turn[] getTurns() {
        return turns;
    }

    public void setTurns(Turn[] turns) {
        this.turns = turns;
    }
}

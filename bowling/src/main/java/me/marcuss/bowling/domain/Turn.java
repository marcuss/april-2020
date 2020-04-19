package me.marcuss.bowling.domain;

public class Turn {
    private Turn nextTurn;
    private Roll firstRoll;
    private Roll secondRoll;
    public Turn getNextTurn() {
        return nextTurn;
    }

    public void setNextTurn(Turn nextTurn) {
        this.nextTurn = nextTurn;
    }

    public Roll getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(Roll firstRoll) {
        this.firstRoll = firstRoll;
    }

    public Roll getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(Roll secondRoll) {
        this.secondRoll = secondRoll;
    }
}

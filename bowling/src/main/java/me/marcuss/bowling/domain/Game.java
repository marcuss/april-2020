package me.marcuss.bowling.domain;

import java.util.Arrays;

public class Game {

    private int[] rolls;
    private int currentRoll;

    public Game() {
        rolls = new int[21];
    }

    @Override
    public String toString() {
        return "Game{" +
                "turns=" + Arrays.toString(rolls) +
                '}';
    }

    public void roll(int pins) {
        this.rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int currentTurn = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (rolls[currentTurn] == 10) {
                score += 10 + nextTwoRollsScore(currentTurn);
                //On strikes a turn only have one roll
                currentTurn += 1;
            }
            else if (isSpare(currentTurn)) {
                //spare
                score += 10 + nextRollScore(currentTurn);
                currentTurn += 2;
            } else {
                score += currentTurnRollsScore(currentTurn);
                currentTurn += 2;
            }

        }
        return score;
    }

    private int currentTurnRollsScore(int currentTurn) {
        return rolls[currentTurn] + rolls[currentTurn+1];
    }

    private int nextRollScore(int currentTurn) {
        return rolls[currentTurn+2];
    }

    private int nextTwoRollsScore(int currentTurn) {
        return rolls[currentTurn + 1] + rolls[currentTurn + 2];
    }

    private boolean isSpare(int currentBallIndex) {
        return rolls[currentBallIndex] + rolls[currentBallIndex+1] == 10;
    }
}

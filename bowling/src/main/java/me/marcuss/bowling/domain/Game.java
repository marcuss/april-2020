package me.marcuss.bowling.domain;

import java.util.Arrays;

public class Game {

    private int[] rolls;
    private int currentRoll;
    private int MAX_ROLL;

    public Game() {
        rolls = new int[21];
        MAX_ROLL = 21;
    }

    @Override
    public String toString() {
        return "Game{" +
                "turns=" + Arrays.toString(rolls) +
                '}';
    }

    public void roll(int pins) {
        if (pins == 10 && currentRoll < MAX_ROLL - 3) {
            //strikes in last turn does not affect max rolls
            MAX_ROLL--;
        }
        if (currentRoll == MAX_ROLL) {
            throw new IllegalArgumentException("Too many rolls");
        }

        this.rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int firstRollInTurn = 0;
        for (int turn = 0; turn < 10; turn++) {
            if (isAStrike(firstRollInTurn)) {
                score += 10 + nextTwoRollsScore(firstRollInTurn);
                //On strikes a turn only have one roll
                firstRollInTurn ++;
            }
            else if (isSpare(firstRollInTurn)) {
                score += 10 + nextRollScore(firstRollInTurn);
                firstRollInTurn += 2;
            } else {
                score += currentTurnRollsScore(firstRollInTurn);
                firstRollInTurn += 2;
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

    private boolean isAStrike(int currentTurn) {
        return rolls[currentTurn] == 10;
    }

    private boolean isSpare(int currentBallIndex) {
        return rolls[currentBallIndex] + rolls[currentBallIndex+1] == 10;
    }
}

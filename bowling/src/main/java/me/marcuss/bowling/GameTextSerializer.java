package me.marcuss.bowling;

import me.marcuss.bowling.domain.Game;

public class GameTextSerializer {
    private Game game;
    private int[] rolls;
    private int currentRoll;
    private int[] scoreByFrame;

    public GameTextSerializer(Game game) {
        this.game = game;
        this.rolls = game.getRolls();
        this.scoreByFrame = game.getScoresByFrame();
        this.currentRoll = 0;
        game.score();
    }

    public String serialize() {
        return serialize(false);
    }

    public String serialize(boolean header) {
        StringBuilder sb = new StringBuilder();
        if (header) {
            sb.append(formatHeader());
        }
        sb.append(formatName(game));
        sb.append(formatPinFallsAndScore(game));
        System.out.println(sb);
        return sb.toString();
    }

    private String formatPinFallsAndScore(Game game) {
        StringBuilder pinfalls = new StringBuilder();
        pinfalls.append(String.format("%-15s", "Pinfalls"));

        StringBuilder scores = new StringBuilder();
        scores.append(String.format("%-15s", "Score"));

        int score = 0;
        int firstRollInTurn = 0;
        for (int turn = 0; turn < 9; turn++) {
            if (isAStrike(firstRollInTurn)) {
                pinfalls.append(String.format("%5s ", "X"));
                firstRollInTurn++;
            } else if (isSpare(firstRollInTurn)) {
                pinfalls.append(
                        String.format("%2d %2s ", rolls[firstRollInTurn], "/")
                );
                firstRollInTurn += 2;
            } else {
                pinfalls.append(
                        String.format("%2d %2d ", rolls[firstRollInTurn], rolls[firstRollInTurn+1])
                );
                firstRollInTurn += 2;
            }
            scores.append(String.format(" %-5d", scoreByFrame[turn]));
        }

        int turn = 9;
        if (isAStrike(firstRollInTurn)) {
            pinfalls.append(String.format("%8s ", "X"));
            firstRollInTurn++;
        } else if (isSpare(firstRollInTurn)) {
            pinfalls.append(
                    String.format("%2d %2s %2d", rolls[firstRollInTurn], "/", rolls[firstRollInTurn+2])
            );
            firstRollInTurn += 2;
        } else {
            pinfalls.append(
                    String.format("%2d %2d   ", rolls[firstRollInTurn], rolls[firstRollInTurn+1])
            );
            firstRollInTurn += 2;
        }
        scores.append(String.format(" %-8d", scoreByFrame[turn]));

        pinfalls.append("\n");
        scores.append("\n");
        return pinfalls.toString() + scores.toString();
    }

    private static String formatName(Game game) {
        return String.format("%-15s\n", game.getPlayerName());
    }

    public static String formatHeader() {
        return String.format("%-15s %-5d %-5d %-5d %-5d %-5d %-5d %-5d %-5d %-5d %-7d\n",
                "Frame", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
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

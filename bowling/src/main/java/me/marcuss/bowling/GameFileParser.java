package me.marcuss.bowling;

import me.marcuss.bowling.domain.Game;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class GameFileParser {

    public static Map<String, Game> readBowlingFile(Path file) {
        //Ordered by player name
        Map<String, Game> games = new TreeMap<>();

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(file)) {
            // read line into games
            stream.forEach(turnStr -> {
                ParsedTurn turn = new ParsedTurn(turnStr).parse();
                Game playerGame = getGameByPlayerName(games, turn.playerName);
                rollTurn(turn.pins, playerGame);
                games.put(turn.playerName, playerGame);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return games;
    }

    private static Game getGameByPlayerName(Map<String, Game> games, String playerName) {
        Game playerGame = games.get(playerName);
        if (playerGame == null) {
            playerGame = new Game();
        }
        return playerGame;
    }

    private static void rollTurn(String pins, Game playerGame) {
        if (NumberUtils.isCreatable(pins)) {
            playerGame.roll(Integer.parseInt(pins));
        } else {
            playerGame.roll(0);
        }
    }

    private static class ParsedTurn {
        private String turnStr;
        public String playerName;
        public String pins;

        public ParsedTurn(String turnStr) {
            this.turnStr = turnStr;
        }

        public ParsedTurn parse() {
        /*format:
              PlayerName Pins
              String     int
              Ex: Jeff 10 */
            String[] turnArr = turnStr.split(" ");
            playerName = turnArr[0];
            pins = turnArr[1];
            return this;
        }
    }
}

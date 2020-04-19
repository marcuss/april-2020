package me.marcuss.bowling;

import me.marcuss.bowling.domain.Game;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class GameFileParser {

    public static Game readBowlingFile(Path file) {
        Game game = new Game();
        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(file)) {
            stream.forEach(System.out::println);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return game;
    }
}

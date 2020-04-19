package me.marcuss.bowling;

import me.marcuss.bowling.domain.Game;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class BowlingApp {

    public static void main(String args[]) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No input file");
        }

        Path file = Paths.get(args[0]);
        if (Files.isReadable(file) != true) {
            throw new IllegalArgumentException("No readable file: " + args[0]);
        }

        Map<String, Game> games = GameFileParser.readBowlingFile(file);

        games.forEach((k,v)->System.out.println( k + ": " + v));
    }
}

package me.marcuss.bowling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class BowlingApp {

    public static void main(String args[]) throws NoSuchFileException {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No input file");
        }

        Path file = Paths.get(args[0]);
        if (Files.isReadable(file) != true) {
            throw new NoSuchFileException(args[0]);
        }

        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(file)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

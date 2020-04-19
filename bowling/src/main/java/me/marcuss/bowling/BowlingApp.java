package me.marcuss.bowling;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class BowlingApp {

    public static void main(String args[]) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("No input file");
        }
        String fileName = args[0];
        // read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

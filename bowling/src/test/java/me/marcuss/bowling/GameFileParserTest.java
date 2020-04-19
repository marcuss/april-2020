package me.marcuss.bowling;

import me.marcuss.bowling.domain.Game;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

class GameFileParserTest {

    @Test
    void readBowlingFileReturnsGameInstance() {

        Path file = Paths.get("src/test/resources/testfile.txt");
        assertThat(
                GameFileParser.readBowlingFile(file),
                instanceOf(Game.class)
        );
    }
}
package me.marcuss.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

class GameFileParserTest {

    private Path sampleFile;
    private Path negativeRollsFile;
    private Path invalidRollsFile;

    @BeforeEach
    public void setup() {
        sampleFile = Paths.get("src/test/resources/testfile.txt");
        negativeRollsFile = Paths.get("src/test/resources/negativeinputs.txt");
        invalidRollsFile = Paths.get("src/test/resources/invalidinputs.txt");
    }

    @Test
    void readBowlingFileReturnsGameInstance() {
        assertThat(
                GameFileParser.readBowlingFile(sampleFile),
                isA(Map.class)
        );
    }

    @Test
    void createOneGamePerPlayerInFile() {
        assertThat(
                GameFileParser.readBowlingFile(sampleFile).size(),
                is(2)
        );
    }

    @Test
    void throwsExceptionOnNegativeRolls() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameFileParser.readBowlingFile(negativeRollsFile).size();
        });
    }

    @Test
    void throwsExceptionOnInvalidRolls() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            GameFileParser.readBowlingFile(invalidRollsFile).size();
        });
    }
}
package me.marcuss.bowling;

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

    @BeforeEach
    public void setup() {
        sampleFile = Paths.get("src/test/resources/testfile.txt");
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


}
package me.marcuss.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BowlingAppTest {

    @Test
    public void testNoInputFileArg() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BowlingApp.main(new String[]{});
        });
    }

    @Test
    public void shouldThrowNoSuchFileException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BowlingApp.main(new String[]{"nonexistentfile.txt"});
        });
    }

    @Test
    public void shouldNotThrowExceptionReadingFile() {
        Assertions.assertDoesNotThrow(() -> {
            BowlingApp.main(new String[]{"src/test/resources/testfile.txt"});
        });
    }
}
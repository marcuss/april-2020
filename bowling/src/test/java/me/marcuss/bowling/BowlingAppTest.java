package me.marcuss.bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowlingAppTest {

    @Test
    public void testNoInputFileArg() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BowlingApp.main(new String[]{});
        });
        ;
    }
}
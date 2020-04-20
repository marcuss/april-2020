package me.marcuss.bowling;

import me.marcuss.bowling.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class GameTextSerializerTest extends AbstractGameTest {

    String allSpareGame = "Frame           1     2     3     4     5     6     7     8     9     10     Test           \nPinfalls        5  /  5  /  5  /  5  /  5  /  5  /  5  /  5  /  5  /  5  /  5\nScore           15    30    45    60    75    90    105   120   135   150     ";
    String perfectGame = "Frame           1     2     3     4     5     6     7     8     9     10     Test           \nPinfalls           X     X     X     X     X     X     X     X     X        X \nScore           30    60    90    120   150   180   210   240   270   300     ";
    @BeforeEach
    public void setup() {
        game = new Game("Test");
    }

    @Test
    public void printsAnAllSparesGame() {
        rollHelper(21, 5);
        assertThat(
                new GameTextSerializer(game).serialize(true),
                is(allSpareGame)
        );
    }

    @Test
    public void printsAPerfectGame() {
        rollHelper(12, 10);
        assertThat(
                new GameTextSerializer(game).serialize(true),
                is(perfectGame)
        );
    }
}
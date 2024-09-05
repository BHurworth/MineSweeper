import org.example.BoardSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardSettingsTest {
    @Test
    public void testConstructor()
    {
        BoardSettings boardSettings = new BoardSettings(10,25,5);
        Assertions.assertEquals(boardSettings.boardWidth, 10);
        Assertions.assertEquals(boardSettings.boardHeight, 25);
        Assertions.assertEquals(boardSettings.numberOfMines, 5);
    }
}

// test flag
// check that if you click a mine you lose
// the big list of naughty strings
// victory condition
// int boardWidth, int boardHeight, int numberOfMines
// pop in at 4
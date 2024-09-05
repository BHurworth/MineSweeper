import org.example.Board;
import org.example.BoardSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BoardTest {
    @Test
    public void testConstructor()
    {
        BoardSettings boardSettings = new BoardSettings(10,25,15);
        Board board = new Board(boardSettings, true);
        Assertions.assertEquals(board.addMines(), 15);
    }
}

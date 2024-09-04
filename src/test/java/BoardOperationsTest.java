import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class BoardOperationsTest {
//    @Test
//    public void TestLossCondition()
//    {
//        BoardSettings boardSettings = new BoardSettings(4,4,16);
//        Board board = new Board(boardSettings, true);
//        board.addMines();
//        BoardOperations boardOperations = new BoardOperations(new BoardSettings());
//
//        boolean died = boardOperations.removePiece(2,3, board.board, new int[]{0});
//        Assertions.assertTrue(died);
//    }

    @Test
    public void CheckFlagged()
    {
        BoardSettings boardSettings = new BoardSettings(10,10,10);
        Board board = new Board(boardSettings);
        BoardOperations boardOperations = new BoardOperations(boardSettings);


        String beforeFlag = board.displayBoardCell(3,3);
        Assertions.assertFalse(beforeFlag.contains("(f)"));

        boardOperations.flagSquare(3,3, board.board);
        String afterFlag  = board.displayBoardCell(3,3);


        Assertions.assertTrue(afterFlag.contains("(f)"));
    }


    @Test
    public void CheckVictoryCondition()
    {
        BoardSettings boardSettings = new BoardSettings(10,10,100);
        Board board = new Board(boardSettings);
        BoardOperations boardOperations = new BoardOperations(boardSettings);
        int[] revealedCellCount = new int[]{0};


        int outcome = boardOperations.removePiece(3,3, board.board, revealedCellCount);
        int outcome2 = boardOperations.removePiece(4,5, board.board, revealedCellCount);
        //-1 =fine
        //0 = mine but dead
        //1 = won
        //2 = mine but fine (first go)
        Assertions.assertEquals(outcome, 2);
        Assertions.assertEquals(outcome2, 0);
    }

    @Test
    public void CheckVictoryConditionAllMines()
    {
        Random rand = new Random();
        for(int i =0; i<200; i++)
        {
            int boardSize = rand.nextInt(100)+3;
            int numberOfMines = boardSize*boardSize;
            BoardSettings boardSettings = new BoardSettings(boardSize,boardSize,numberOfMines);
            Board board = new Board(boardSettings);
            BoardOperations boardOperations = new BoardOperations(boardSettings);
            int[] revealedCellCount = new int[]{0};

            int x = rand.nextInt(boardSize-1)+1;
            int y = rand.nextInt(boardSize-1)+1;
            int outcome = boardOperations.removePiece(x,y, board.board, revealedCellCount);

            int x2 = x;
            int y2= y;

            while(x2 == x)
                x2 = rand.nextInt(boardSize-1)+1;

            while(y2==y)
                y2 = rand.nextInt(boardSize-1)+1;

            int outcome2 = boardOperations.removePiece(x2,y2, board.board, revealedCellCount);


            //-1 =fine
            //0 = mine but dead
            //1 = won
            //2 = mine but fine (first go)
            Assertions.assertEquals(outcome, 2);
            Assertions.assertEquals(outcome2, 0);
        }
    }
}



// test flag
// check that if you click a mine you lose
// the big list of naughty strings
// victory condition
// int boardWidth, int boardHeight, int numberOfMines
// pop in at 4

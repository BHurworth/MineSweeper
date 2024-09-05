package org.example;

public class BoardManager {
    BoardOperations boardOperations;

    public int UpdateBoardState(int action, Board board, int[] revealedCellCount)
    {
        if(boardOperations == null)
        {
            boardOperations = new BoardOperations(board.boardSettings);
        }

        int gameState = -1;

        switch(action)
        {
            case 1:
                gameState = boardOperations.RemoveASquare(board.board, revealedCellCount);
                break;
            case 2:
                boardOperations.FlagNewSquare(true, board.board);
                break;
            case 3:
                boardOperations.FlagNewSquare(false, board.board);
                break;
            default:
                System.exit(0);
                break;
        }
        return gameState;
    }
}

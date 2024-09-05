package org.example;

public class MineSweeperGame {
    int[] revealedCellCount =  new int[]{0};
    public Board board = new Board();
    boolean playing = true;
    BoardManager boardManager = new BoardManager();

    public void StartNewGame(){
        InitialiseBoard();
        board.displayBoard();

        int gameState = -1;
        int input = 0;

        while(playing)
        {
            input = InputMenu.PlayerInputMenu();

            gameState = boardManager.UpdateBoardState(input, board, revealedCellCount);

            board.displayBoard();

            if(gameState == 0 || gameState == 1)
            {
                InitialiseBoard();
            }
        }
    }

    public void InitialiseBoard()
    {
        revealedCellCount[0] = 0;
        BoardSettings settings = InitialiseBoardSettings();
        board = new Board(settings);
    }

    public BoardSettings InitialiseBoardSettings()
    {
        return InputMenu.BoardSettingsInputMenu();
    }

//    public void InitialiseBoardSettings2()
//    {
//
//        BoardSettings boardSettings;
//        boardSettings = InputMenu.BoardSettingsInputMenu();
//        board = new Board(boardSettings);
//    }
}

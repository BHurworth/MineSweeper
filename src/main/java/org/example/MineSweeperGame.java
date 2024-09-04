package org.example;

public class MineSweeperGame {
    int highScore = 0;
    int numberOfTimesPlayed = 0;
    int[] revealedCellCount =  new int[]{0};
    public Board board = new Board();

    public void StartNewGame(){
        // initialise board settings
        // start game
        InitialiseBoardSettings();

        InputMenu inputMenu = new InputMenu();
        boolean gameOver = false;

        while(true)
        {
            gameOver = inputMenu.PlayerInputMenu(board, revealedCellCount);
            if(gameOver)
            {
                InitialiseBoardSettings();
            }

            else if(revealedCellCount[0] > ((board.boardSettings.boardHeight)* board.boardSettings.boardWidth) - board.boardSettings.numberOfMines)
            {
                System.out.println("YOU WON!");
                InitialiseBoardSettings();
            }
        }
       // numberOfTimesPlayed++;
    }

    public void InitialiseBoardSettings()
    {
        revealedCellCount[0] = 0;
        BoardSettings boardSettings;
        boardSettings = InputMenu.BoardSettingsInputMenu();
        board = new Board(boardSettings);
    }
}

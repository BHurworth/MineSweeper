package org.example;

public class MineSweeperGame {
    int highScore = 0;
    int numberOfTimesPlayed = 0;
    public Board board = new Board();

    public void StartNewGame(){
        // initialise board settings
        // start game
        InitialiseBoard();

        InputMenu inputMenu = new InputMenu();
        boolean gameOver = false;

        while(true)
        {
            gameOver = inputMenu.PlayerInputMenu(board);
            if(gameOver)
            {
                InitialiseBoard();
            }
        }
       // numberOfTimesPlayed++;
    }

    public void InitialiseBoard()
    {
        BoardSettings boardSettings;
        boardSettings = InputMenu.BoardSettingsInputMenu();
        board = new Board(boardSettings);
    }

}

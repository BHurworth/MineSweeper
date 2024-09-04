package org.example;

public class MineSweeperGame {
    int highScore = 0;
    int numberOfTimesPlayed = 0;
    public Board board = new Board();

    public void StartNewGame(){
        // initialise board settings
        // start game
        BoardSettings boardSettings;
        boardSettings = InputMenu.BoardSettingsInputMenu();
        Board board = new Board(boardSettings);

        InputMenu inputMenu = new InputMenu();
        boolean gameOver;

        while(true)
        {
            gameOver = inputMenu.PlayerInputMenu(board);
            if(gameOver)
            {
                StartNewGame();
                break;
            }
        }
       // numberOfTimesPlayed++;
    }
}

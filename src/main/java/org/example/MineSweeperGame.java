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
        inputMenu.PlayerInputMenu(board);

        numberOfTimesPlayed++;
    }
}

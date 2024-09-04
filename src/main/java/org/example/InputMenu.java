package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class InputMenu {
    BoardOperations boardOperations = new BoardOperations();
    public void PlayerInputMenu(ArrayList<ArrayList<BoardPiece>> board)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter an input: " + "\n1. To reveal a square" + "\n2. To flag a block" + "\n3. Remove flag from a block" + "\n4. To Quit the game");
        while(!scanner.hasNextInt())
        {
            scanner.next();
        }
        int choice = scanner.nextInt();

       // return choice;

        switch(choice)
        {
            case 1:
                boardOperations.RemoveASquare(board);
                break;
            case 2:
                boardOperations.FlagNewSquare(true, board);
                break;
            case 3:
                boardOperations.FlagNewSquare(false, board);
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static BoardSettings BoardSettingsInputMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a difficulty" + "\n1. Easy" + "\n2. Intermediate" + "\n3. Custom");

        while(!scanner.hasNextInt())
        {
            scanner.next();
        }
        int difficulty = scanner.nextInt();
        BoardSettings boardSettings = new BoardSettings();
        switch(difficulty)
        {
            case(1):
                boardSettings.boardWidth = 8;
                boardSettings.boardHeight = 8;
                boardSettings.numberOfMines = 10;
                break;

            case(2):
                boardSettings.boardWidth = 16;
                boardSettings.boardHeight = 16;
                boardSettings.numberOfMines = 40;
                break;
//            case 3:
//                getCustomDifficulty();
//                break;
            default:
                break;
        }

        return boardSettings;
    }

}

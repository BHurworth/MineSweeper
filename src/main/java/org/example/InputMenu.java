package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class InputMenu {
    BoardOperations boardOperations;
    public void PlayerInputMenu(Board board)
    {
        if(boardOperations == null)
        {
            boardOperations = new BoardOperations(board.boardSettings);
        }
        board.displayBoard();
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
                boardOperations.RemoveASquare(board.board);
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

        board.displayBoard();
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
        BoardSettings boardSettings;
        switch(difficulty)
        {
            case(1):
                boardSettings = new BoardSettings(8,8,10);
                break;

            case(2):
                boardSettings = new BoardSettings(16,16,40);
                break;
            case 3:
                boardSettings = new BoardSettings();
                boardSettings = boardSettings.getCustomDifficulty();
                break;
            default:
                boardSettings = new BoardSettings();
                break;
        }

        return boardSettings;
    }






}

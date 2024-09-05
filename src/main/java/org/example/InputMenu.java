package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class InputMenu {
    BoardOperations boardOperations;

    public static int PlayerInputMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\nEnter an input: " + "\n1. To reveal a square" + "\n2. To flag a block" + "\n3. Remove flag from a block" + "\n4. To Quit the game");
        while(!scanner.hasNextInt())
        {
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static BoardSettings BoardSettingsInputMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n\nEnter a difficulty" + "\n1. Easy" + "\n2. Intermediate" + "\n3. Custom");

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

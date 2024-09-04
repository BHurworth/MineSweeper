package org.example;

import java.util.Scanner;

public class BoardSettings {
    int boardHeight = 8;
    int boardWidth = 8;

    public int numberOfMines = 10;

    public void BoardSettings()
    {

    }

    public void getCustomDifficulty()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Board size");
        while(!scanner.hasNextInt())
        {
            scanner.next();
        }
        boardWidth = scanner.nextInt();
        boardHeight = boardWidth;

        System.out.println("Enter number of mines");
        while(!scanner.hasNextInt())
        {
            scanner.next();
        }
        numberOfMines = scanner.nextInt();
    }
}

package org.example;

import java.util.Scanner;

public class BoardSettings {
    public int boardHeight = 8;
    public int boardWidth = 8;

    public int numberOfMines = 10;

    public BoardSettings()
    {

    }

    public BoardSettings(int boardWidth, int boardHeight, int numberOfMines)
    {
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.numberOfMines = numberOfMines;
    }

    public BoardSettings getCustomDifficulty()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Board size");
        while(!scanner.hasNextInt())
        {
            scanner.next();
        }
        int boardWidth = scanner.nextInt();
        System.out.println("Enter number of mines");
        while(!scanner.hasNextInt())
        {
            scanner.next();
        }
        int numberOfMines = scanner.nextInt();

        return new BoardSettings(boardWidth, boardWidth, numberOfMines);
    }
}

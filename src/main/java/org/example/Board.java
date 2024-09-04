package org.example;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

import java.util.ArrayList;

public class Board {
    ArrayList<ArrayList<BoardPiece>> board = new ArrayList<ArrayList<BoardPiece>>();
    ArrayList<ArrayList<Integer>> visitedNodes = new ArrayList<ArrayList<Integer>>();
    int numberOfRevealedBlocks = 0;
    int[][] eightDirections = new int[][]{{-1,1}, {-1,-1}, {-1,0},{1,0},{1,1}, {1,-1}, {0,1},{0,-1}};
    boolean playing = true;
    Instant startTime;
    Instant currentTime;
    BoardSettings boardSettings = new BoardSettings();

    public Board()
    {

    }

    public Board(BoardSettings settings)
    {
        this.boardSettings = settings;
        initialiseBoard();
        addMines();
    }


//    public void startNewGame()
//    {
//        startTime = Instant.now();
//        initialiseBoard();
//        addMines();
//        TestBoardDisplay();
//        CalculateNumbers();
//        TestBoardDisplay();
//        displayBoard();
//
//        while(playing)
//        {
//            Menu();
//        }
//    }

   // loop 10 times and pick random position on board
    public void initialiseBoard()
    {
        board.clear();
        for(int i =0; i<boardSettings.boardHeight+1; i++)
        {
            board.add(new ArrayList<BoardPiece>());
            for(int j =0; j<boardSettings.boardWidth+1; j++)
            {
                if(i == 0)
                {
                    GridLabel gridLabel = new GridLabel();
                    char b = (char)(j-1 + 'a');
                    gridLabel.type = b + "   ";
                    if(j<=0)
                        gridLabel.type = "    ";
                    board.get(i).add(gridLabel);
                }

                 else if(j == 0)
                {
                    GridLabel gridLabel = new GridLabel();
                    gridLabel.type = Integer.toString((i));
                    if(i <=0)
                        gridLabel.type = "   ";
                    board.get(i).add(gridLabel);
                }
                else
                {
                    EmptyPiece emptyPiece = new EmptyPiece();
                    board.get(i).add(emptyPiece);
                }

            }
        }
    }



    public void TestBoardDisplay()
    {
        for(int i =0; i<boardSettings.boardHeight+1; i++)
        {
            System.out.println("\n");
            for(int j =0; j<boardSettings.boardWidth+1; j++)
            {
                BoardPiece currentPiece = board.get(i).get(j);
                // System.out.print(currentPiece.type + " ");
                boolean visibleSave = currentPiece.visible;
                currentPiece.visible = true;
                currentPiece.displayPiece();
                currentPiece.visible = visibleSave;
            }
        }
    }

    public void displayBoard()
    {
        for(int i =0; i<boardSettings.boardHeight+1; i++)
        {
            System.out.println("\n");
            for(int j =0; j<boardSettings.boardWidth+1; j++)
            {
                    BoardPiece currentPiece = board.get(i).get(j);
                    currentPiece.displayPiece();
            }
        }

        currentTime = Instant.now();

        long timeElapsed = Duration.between(startTime, currentTime).toSeconds();
        System.out.println("\n\n" +timeElapsed + " seconds elapsed");
    }





    public void addMines()
    {
        Random rand = new Random();
        int height = board.size()-1;
        int width = board.get(0).size()-1;

        for(int i =0; i<boardSettings.numberOfMines; i++)
        {
            int randX = rand.nextInt(height)+1;
            int randY = rand.nextInt(width)+1;
            ArrayList<Integer> newPosition = new ArrayList<Integer>();
            newPosition.add(randX);
            newPosition.add(randY);

            if(board.get(randX).get(randY).type == "null")
            {
               // placedMines.add(newPosition);
                Mine mine = new Mine();
                board.get(randX).set(randY, mine);
            }
            else {
                --i;
            }
        }
    }
    // initialise board
    // breadth first search first click
}
// Place flags
// remove flags
// initialise board

// need to think about how to flag stuff. If you flag a piece, it should still stay the same. So the flag shouldnt really be a piece
// instead, the pieces should have a property of "isFlagged", which when true will somehow display that it is flagged
/*
    Place bombs,
    loop through board and calculate the numbers for each piece
 */
// breadth first search first click

// win and loss con
// display outcome
// restart game

//difficulty based on number of bombs

// Add Ability to add flag
// Add square selection option
// Add some kind of searching algorithm that keeps going until all numbers have been reached
// if it is a bomb i guess it removes it?
// (Check in all 8 directions, if it is null, reveal it, if it is a number stop the search. if it is a bomb, stop? I guess it wont ever be a bomb?)

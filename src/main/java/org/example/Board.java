package org.example;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

import java.util.ArrayList;

public class Board {
    ArrayList<ArrayList<BoardPiece>> board = new ArrayList<ArrayList<BoardPiece>>();
    int[][] eightDirections = new int[][]{{-1,1}, {-1,-1}, {-1,0},{1,0},{1,1}, {1,-1}, {0,1},{0,-1}};
    BoardSettings boardSettings = new BoardSettings();

    public Board()
    {
    }

    public Board(BoardSettings settings)
    {
        this.boardSettings = settings;
        initialiseBoard();
        addMines();
        addNumbers();
    }

    public void addNumbers()
    {
        for(int i =1; i<boardSettings.boardHeight+1; i++)
        {
            System.out.println("\n");
            for(int j =1; j<boardSettings.boardWidth+1; j++)
            {
                int count = 0;

                for(int[] direction : eightDirections)
                {
                    int positionToCheckX = i + direction[0];
                    int positionToCheckY = j+direction[1];
                    if((positionToCheckX >= 0 && positionToCheckX < boardSettings.boardWidth) && (positionToCheckY < boardSettings.boardHeight && positionToCheckY >= 0) && board.get(positionToCheckX).get(positionToCheckY).type != "null")
                    {
                        BoardPiece currentPiece = board.get(positionToCheckX).get(positionToCheckY);
                        if(currentPiece.type.equals("Mine"))
                            count++;
                    }
                }

                if(count > 0 && board.get(i).get(j).type == "null")
                {
                    Number number = new Number();
                    number.type = "  " + Integer.toString(count) + " ";
                    board.get(i).set(j, number);
                }
            }
        }
    }

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
}

package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardOperations {
    int numberOfRevealedBlocks = 0;
    ArrayList<ArrayList<Integer>> visitedNodes = new ArrayList<ArrayList<Integer>>();
    public BoardSettings boardSettings;
    int[][] eightDirections = new int[][]{{-1,1}, {-1,-1}, {-1,0},{1,0},{1,1}, {1,-1}, {0,1},{0,-1}};

    public void removePiece(int x, int y, ArrayList<ArrayList<BoardPiece>> board)
    {
        //3 posibilities
        /*
            1. the piece is a mine
                - Game over

            2. the piece is a number
                - reveal the piece

            3. the piece is null
                - reveal all adjacent null pieces recursively
        */

        BoardPiece removedPiece = board.get(x).get(y);

        if(removedPiece.type == "null")
        {
            System.out.println("WAS NULL");
            removedPiece.visible = true;
            Reveal(x,y, board);
            visitedNodes.clear();
        }

        else if(removedPiece.type == "Mine" && numberOfRevealedBlocks >0)
        {
            removedPiece.visible = true;
            RevealAllBombs();
            System.out.println("\nGame Over!");
            System.exit(0);
        }

        else if(removedPiece.type == "Mine" && numberOfRevealedBlocks ==0)
        {
            EmptyPiece empty = new EmptyPiece();
            empty.visible = true;
            board.get(x).set(y, empty);
        }

        else
        {
            removedPiece.visible = true;
            System.out.println("WAS NUMBER");
        }
        numberOfRevealedBlocks++;
        //displayBoard();
    }

    public void Reveal(int x, int y, ArrayList<ArrayList<BoardPiece>> board)
    {
        ArrayList<Integer> currentNode = new ArrayList<Integer>();
        currentNode.add(x);
        currentNode.add(y);

        if(visitedNodes.contains(currentNode))
            return;

        visitedNodes.add(currentNode);
        if(x> boardSettings.boardWidth || x<0 || y>boardSettings.boardHeight || y<0)
            return;
        BoardPiece currentPiece = board.get(x).get(y);

        if(currentPiece != null && currentPiece.type == "Mine")
            return;

        if(currentPiece.type != "null")
        {
            currentPiece.visible = true;
            return;
        }

        else
        {
            currentPiece.visible = true;
            for(int[] direction : eightDirections)
            {
                int positionToCheckX = x + direction[0];
                int positionToCheckY = y+direction[1];
                Reveal(positionToCheckX, positionToCheckY, board);
            }
        }
    }

    public void CalculateNumbers(ArrayList<ArrayList<BoardPiece>> board)
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

    public void RevealAllBombs(ArrayList<ArrayList<BoardPiece>> board)
    {
        for(int i =0; i<boardSettings.boardHeight+1; i++)
        {
            System.out.println("\n");
            for(int j =0; j<boardSettings.boardWidth+1; j++)
            {
                BoardPiece currentPiece = board.get(i).get(j);
                if(currentPiece.type == "Mine")
                    currentPiece.visible = true;
                currentPiece.displayPiece();
            }
        }
    }

    public void RemoveASquare(ArrayList<ArrayList<BoardPiece>> board)
    {
        int[] input = ReceiveInput();
        removePiece(input[0],input[1], board);
    }

    public int[] ReceiveInput()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a number");
        while(!scanner.hasNextInt())
        {
            scanner.next();
        }
        int x = scanner.nextInt();
        System.out.println("Enter a character");
        char yChar = scanner.next().charAt(0);


        int y = yChar - 'a' + 1;
        System.out.println("You entered: " + x + " and " + y);
        int[] input = new int[]{x,y};
        return input;
    }

    public void FlagNewSquare(boolean flag, ArrayList<ArrayList<BoardPiece>> board)
    {
        int[] input = ReceiveInput();
        if(flag)
            flagSquare(input[0],input[1], board);
        else
            unFlagSquare(input[0],input[1], board);
    }

    public void flagSquare(int x, int y, ArrayList<ArrayList<BoardPiece>> board)
    {
        board.get(x).get(y).isFlagged = true;
       // displayBoard();
    }

    public void unFlagSquare(int x, int y, ArrayList<ArrayList<BoardPiece>> board)
    {
        board.get(x).get(y).isFlagged = false;
       // displayBoard();
    }
}
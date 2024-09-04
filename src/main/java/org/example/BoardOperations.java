package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardOperations {
    int numberOfRevealedBlocks = 0;
    ArrayList<ArrayList<Integer>> visitedNodes = new ArrayList<ArrayList<Integer>>();
    public BoardSettings boardSettings;
    int[][] eightDirections = new int[][]{{-1,1}, {-1,-1}, {-1,0},{1,0},{1,1}, {1,-1}, {0,1},{0,-1}};

    public BoardOperations(BoardSettings settings)
    {
        this.boardSettings = settings;
    }

    public boolean removePiece(int x, int y, ArrayList<ArrayList<BoardPiece>> board, int[] revealedCellCount)
    {
        BoardPiece removedPiece = board.get(x).get(y);

        if(removedPiece.type == "null")
        {
            System.out.println("WAS NULL");;
            Reveal(x,y, board, revealedCellCount);
            visitedNodes.clear();
        }

        else if(removedPiece.type == "Mine" && revealedCellCount[0]>0)
        {
            removedPiece.visible = true;
            RevealAllBombs(board);
            System.out.println("\nGame Over!");
            return true;
            //System.exit(0);
        }

        else if(removedPiece.type == "Mine" && revealedCellCount[0]==0)
        {
            revealedCellCount[0]++;
            EmptyPiece empty = new EmptyPiece();
            empty.visible = true;
            board.get(x).set(y, empty);
        }

        else
        {
            if(removedPiece.visible != true)
            {
                revealedCellCount[0]++;
                removedPiece.visible = true;
            }
            System.out.println("WAS NUMBER");
        }

        numberOfRevealedBlocks++;
        System.out.println("TEST " + revealedCellCount[0]);
        System.out.println("TEST2 " + numberOfRevealedBlocks);
        return false;
        //displayBoard();
    }

    public void Reveal(int x, int y, ArrayList<ArrayList<BoardPiece>> board, int[] revealedCellCount)
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

        if(currentPiece != null && currentPiece.type != "null")
        {
            if(currentPiece.visible != true)
            {
                currentPiece.visible = true;
                revealedCellCount[0]++;
            }
            return;
        }

        else
        {
            if(currentPiece.visible!= true)
            {
                currentPiece.visible = true;
                revealedCellCount[0]++;
            }
            for(int[] direction : eightDirections)
            {
                int positionToCheckX = x + direction[0];
                int positionToCheckY = y+direction[1];
                Reveal(positionToCheckX, positionToCheckY, board, revealedCellCount);
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

    public boolean RemoveASquare(ArrayList<ArrayList<BoardPiece>> board, int[] revealedCellCount)
    {
        int[] input = ReceiveInput();
       return removePiece(input[0],input[1], board, revealedCellCount);
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

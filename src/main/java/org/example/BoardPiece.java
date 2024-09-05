package org.example;

public abstract class BoardPiece {
        int[] position = new int[2];
         public boolean visible = false;
        boolean isFlagged = false;
        public  String type ="";


        public String displayPiece(){
                String outputType = "";
                if(!visible)
                {
                       // System.out.print("   []   ");
                        outputType = ("   []   ");
                        if(isFlagged)
                                outputType = ("   [](f)");
                        System.out.print(outputType);
                }

                else
                {
                        outputType = type;
                        if(isFlagged)
                                outputType += "(f)";

                        while(outputType.length() < 4)
                        {
                                outputType += " ";
                        }
                        System.out.print( "  " + outputType + "  ");
                }
                return outputType;
        };
}

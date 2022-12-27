/* this class is responsible for providing movement pattern for king piece
    and also loading its graphics reference as well as setting the piece
     name*/
public class King extends ChessPiece 
{
    private static String pieceName="KING";
    /*below constructor is used to set color of piece and board in 
     use*/
    public King(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("KingBlack.png","KingWhite.png");
    }
    /* below constructor is used to set name of the piece, and the
       board in use*/
    public King(String newColor,Board theBoard){
        super(pieceName,newColor,theBoard);
        setGraphics("KingBlack.png","KingWhite.png");
    }
    /* below method is responsible for setting the movement pattern of the
      piece*/
    public boolean isValidMove(int currentRow,int currentCol,int futureRow,int futureCol){
        boolean logic=false;
        Board x=getBoard();
        int allowedMoves=1;
        int currentMovesRow=futureRow-currentRow;
        int currentMovesCol=futureCol-currentCol;
        int diagonal=futureRow-futureCol;
        // if condition has to be extended for diagonal moves so that we can restrict it to 1 move only 
        /* below if condition is responsible for setting pattern for white King piece
           as well as detecting any piece surrounding it and returning the state
           if it's availabel to make move to current detected piece location*/
        if((getColor().equals("WHITE")&&(x.getPieceColor(futureRow,futureCol).equals("WHITE")!=true))){
            if(futureRow-currentRow==1||futureRow-currentRow==-1||futureRow==currentRow){
                if(futureCol-currentCol==1||futureCol-currentCol==-1||futureCol==currentCol){
                    logic=true;
                }
                else{
                    logic=false;
                }
            }
        }
        /* below  else if condition is responsible for setting pattern for Black King piece
           and does the same as the upper if statement*/
        else if((getColor().equals("BLACK")&&(x.getPieceColor(futureRow,futureCol).equals("BLACK")!=true))){
            if(futureRow-currentRow==1||futureRow-currentRow==-1||futureRow==currentRow){
                if(futureCol-currentCol==1||futureCol-currentCol==-1||futureCol==currentCol){
                    logic=true;
                }
                else{
                    logic=false;
                }
            }
        }
        /*below else is used to restrict movements if the 2 previous
          statements are not met */ 
        else{
            logic=false;
        }
        return logic;
    }
}

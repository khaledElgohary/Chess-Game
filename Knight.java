/*this class is used to set the piecename for the knight piece, as well
   as provide graphics for the piece, and also set the movement pattern
   for the piece
note:- for this movement pattern, we don't need to rely on the idea of the
bounds or available tiles to move to , since this piece can jump on top of
 the other piece , therefore we only need to check if a piece is visible at
 the desired location on the board or not.*/
public class Knight extends ChessPiece
{
    private static String pieceName="KNIGHT";
    /*below constructor is used to set the color of the piece,
       and also the current board in use, and provide graphics
       for the piece*/
    public Knight(String name, String newColor,Board theBoard)
    {
        super(name,newColor,theBoard);
        setGraphics("KnightBlack.png","KnightWhite.png");
    }
    /*below constructor is used to set the name of the knight piece, as well
       as provide it's graphics , color, and current board in use*/
    public Knight(String newColor,Board theBoard){
        super(pieceName,newColor,theBoard);
        setGraphics("KnightBlack.png","KnightWhite.png");
    }
    /*below method is used to set the movement pattern for the knight
       piece*/
    public boolean isValidMove(int currentRow,int currentCol,int futureRow,int futureCol){
        boolean logic=false;
        Board x=getBoard();
        /*below method is used to detect if there is a piece visible in
           the direction the knight is allowed to travel , and if there is
           a piece it decideds whether the piece can be taken out by knight
           or not */
        if(x.getPieceColor(futureRow,futureCol).equals(getColor())!=true){
            if((futureRow-currentRow>0 &&futureRow-currentRow<3)||(futureRow-currentRow<0 && futureRow-currentRow>-3)){
                if((futureCol-currentCol==1)||(futureCol-currentCol==-1)){
                    logic=true;
                }
                else if((futureCol-currentCol==2)||(futureCol-currentCol==-2)){
                    if(futureRow-currentRow==1||futureRow-currentRow==-1){
                        logic=true;
                    }
                }
            }
            else{
                logic=false;
            }
        }
        else{
            logic=false;
        }
        if((futureRow-currentRow==1 || futureRow-currentRow==-1)&&((futureCol-currentCol==1)||(futureCol-currentCol==-1))){
            logic=false;
        }
        return logic;
    }
}

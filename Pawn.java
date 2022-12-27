/*this class is used to set the name of the pawn chess piece, as well as 
   the graphics for the piece, and set the movement pattern of the piece*/
public class Pawn extends ChessPiece 
{
    // instance variables - replace the example below with your own
    private static String pieceName="PAWN";
    Board x=getBoard();
    private int boardSize=7;
    /*below constructor is used to set the color of the piece, as well as
       the current board in use , and provide graphics for the piece*/
    public Pawn(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("PawnBlack.png","PawnWhite.png");
    }
    /*below constructor is used to set the color of the piece, as well as
       the current board in use,provide graphics for the board , and set the
       name of the piece*/
    public Pawn(String newColor,Board theBoard){
        super(pieceName,newColor,theBoard);
        setGraphics("PawnBlack.png","PawnWhite.png");
    }
    /*below method is used to set the movement pattern for the pawn piece*/
        public boolean isValidMove(int currentRow,int currentCol,int futureRow,int futureCol){
        boolean logic=false;
        boolean colorDetect=getColor().equals(x.getPiece(currentRow,currentCol));
        int[][] validCells=validCells(currentRow,currentCol);
        for(int r=0;r<validCells.length;r++){
            for(int c=0;c<validCells[0].length;c++){
                if(validCells[r][c]!=0&&futureRow==r&&futureCol==c){
                    return true;
                }
                if(futureRow==currentRow&&futureCol==currentCol){
                    return false;
                }
            }
        }
        /*below print statement is used to printout a 2d array representing
           table and also the available tiles the chosen piece can move to,
           can be used to imagine how the movement pattern works for this class*/
        System.out.println(toString(validCells));
        return logic;
    }
    /* below method is used to detect the valid cells available for the pawn
       piece to move to on the board*/
    public int[][] validCells(int currentRow,int currentCol){
        int allowedMoves=1;
        int[][] validCells=new int[8][8];
        validCells[currentRow][currentCol]=5;
        /*below if statement is used to detect what color of piece is used, and 
           detect if we are allowed to move 2 places according starting position
           of the piece, and also detects if there is a piece diagonally ,and
           if it can be taken by the pawn or not*/
        if(getColor().equals("WHITE")&&currentRow<7&&currentCol>0&&currentCol<7){
            if(currentRow==1){
                if(x.hasPiece(currentRow+1,currentCol)){
                    validCells[currentRow+1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow+1,currentCol)!=true){
                    validCells[currentRow+1][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol)!=true&&x.hasPiece(currentRow+2,currentCol)!=true){
                    System.out.println("in");
                    validCells[currentRow+2][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol+1)==true && getColor().equals(x.getPieceColor(currentRow+1,currentCol+1))!=true){
                    validCells[currentRow+1][currentCol+1]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol-1)==true && getColor().equals(x.getPieceColor(currentRow+1,currentCol-1))!=true){
                    validCells[currentRow+1][currentCol-1]=1; 
                }
            }
            else{
                if(x.hasPiece(currentRow+1,currentCol)){
                    validCells[currentRow+1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow+1,currentCol)!=true){
                    validCells[currentRow+1][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol+1)==true && getColor().equals(x.getPieceColor(currentRow+1,currentCol+1))!=true){
                    validCells[currentRow+1][currentCol+1]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol-1)==true && getColor().equals(x.getPieceColor(currentRow+1,currentCol-1))!=true){
                    validCells[currentRow+1][currentCol-1]=1; 
                }
            }
        }
        /*below else if is used to detect if we are at col 0, thus 
           we won't detect if there is a piece available at the left
           diagonal side(out of the board limit)*/
        else if(getColor().equals("WHITE")&&currentCol==0){
            if(currentRow==1){
                if(x.hasPiece(currentRow+1,currentCol)){
                    validCells[currentRow+1][currentCol]=0;
                }
                    else if(x.hasPiece(currentRow+1,currentCol)!=true){
                    validCells[currentRow+1][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol)!=true&&x.hasPiece(currentRow+2,currentCol)!=true){
                    System.out.println("in");
                    validCells[currentRow+2][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol+1)==true && getColor().equals(x.getPieceColor(currentRow+1,currentCol+1))!=true){
                    validCells[currentRow+1][currentCol+1]=1;
                }
            }
            else{
                if(x.hasPiece(currentRow+1,currentCol)){
                    validCells[currentRow+1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow+1,currentCol)!=true){
                    validCells[currentRow+1][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol+1)==true && getColor().equals(x.getPieceColor(currentRow+1,currentCol+1))!=true){
                    validCells[currentRow+1][currentCol+1]=1;
                }
            }
        }
        /*below else if statement is used to detect if we are at col 7,
           thus we won't detect if there is a piece available at right 
           diagonal side(out of board limit)*/
        else if(color.equals("WHITE")&&currentCol==7){
            if(currentRow==1){
                if(x.hasPiece(currentRow+1,currentCol)){
                    validCells[currentRow+1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow+1,currentCol)!=true){
                    validCells[currentRow+1][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol)!=true&&x.hasPiece(currentRow+2,currentCol)!=true){
                    System.out.println("in");
                    validCells[currentRow+2][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol-1)==true && getColor().equals(x.getPieceColor(currentRow+1,currentCol-1))!=true){
                    validCells[currentRow+1][currentCol-1]=1; 
                }
            }
            else{
                if(x.hasPiece(currentRow+1,currentCol)){
                    validCells[currentRow+1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow+1,currentCol)!=true){
                    validCells[currentRow+1][currentCol]=1;
                }
                if(x.hasPiece(currentRow+1,currentCol-1)==true && getColor().equals(x.getPieceColor(currentRow+1,currentCol-1))!=true){
                    validCells[currentRow+1][currentCol-1]=1; 
                }
            }
        }
        /*below if statement is used to detect if the piece color chosen
           is black , and also detect if we can move 2 places according to
           our starting position , and detect if there is a piece available
           diagonally , and if it can be taken out by pawn*/
        if(getColor().equals("BLACK")&&currentRow>0&&currentCol>0&&currentCol<7){
            if(currentRow==6){
                if(x.hasPiece(currentRow-1,currentCol)){
                    validCells[currentRow-1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow-1,currentCol)!=true){
                    validCells[currentRow-1][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol)!=true && x.hasPiece(currentRow-2,currentCol)!=true){
                    validCells[currentRow-2][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol+1)==true&&getColor().equals(x.getPieceColor(currentRow-1,currentCol+1))!=true){
                    validCells[currentRow-1][currentCol+1]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol-1)==true&&getColor().equals(x.getPieceColor(currentRow-1,currentCol-1))!=true){
                    validCells[currentRow-1][currentCol-1]=1;
                }
            }
            else{
                if(x.hasPiece(currentRow-1,currentCol)){
                    validCells[currentRow-1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow-1,currentCol)!=true){
                    validCells[currentRow-1][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol+1)==true&&getColor().equals(x.getPieceColor(currentRow-1,currentCol+1))!=true){
                    validCells[currentRow-1][currentCol+1]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol-1)==true&&getColor().equals(x.getPieceColor(currentRow-1,currentCol-1))!=true){
                    validCells[currentRow-1][currentCol-1]=1;
                }
            }
        }
        /*below else if is used to detect if we are at col 0, thus we won't
           detect if there is a piece available diagonally down left side
           (out of board limit)*/
        else if(getColor().equals("BLACK")&&currentCol==0){
            if(currentRow==6){
                if(x.hasPiece(currentRow-1,currentCol)){
                    validCells[currentRow-1][currentCol]=0;
                }
                    else if(x.hasPiece(currentRow-1,currentCol)!=true){
                    validCells[currentRow-1][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol)!=true && x.hasPiece(currentRow-2,currentCol)!=true){
                    validCells[currentRow-2][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol+1)==true&&getColor().equals(x.getPieceColor(currentRow-1,currentCol+1))!=true){
                    validCells[currentRow-1][currentCol+1]=1;
                }
            }
            else{
                if(x.hasPiece(currentRow-1,currentCol)){
                    validCells[currentRow-1][currentCol]=0;
                    }
                else if(x.hasPiece(currentRow-1,currentCol)!=true){
                    validCells[currentRow-1][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol+1)==true&&getColor().equals(x.getPieceColor(currentRow-1,currentCol+1))!=true){
                    validCells[currentRow-1][currentCol+1]=1;
                }
            }
        }
        /*below else if is used to detect if we are at col 7, thus we won't
           detect if there is a piece available diagonally down right side
           (out of board limit)*/
        else if(getColor().equals("BLACK")&&currentCol==7){
            if(currentRow==6){
                if(x.hasPiece(currentRow-1,currentCol)){
                    validCells[currentRow-1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow-1,currentCol)!=true){
                    validCells[currentRow-1][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol)!=true && x.hasPiece(currentRow-2,currentCol)!=true){
                    validCells[currentRow-2][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol-1)==true&&getColor().equals(x.getPieceColor(currentRow-1,currentCol-1))!=true){
                    validCells[currentRow-1][currentCol-1]=1;
                }
            }
            else{
                if(x.hasPiece(currentRow-1,currentCol)){
                    validCells[currentRow-1][currentCol]=0;
                }
                else if(x.hasPiece(currentRow-1,currentCol)!=true){
                    validCells[currentRow-1][currentCol]=1;
                }
                if(x.hasPiece(currentRow-1,currentCol-1)==true&&getColor().equals(x.getPieceColor(currentRow-1,currentCol-1))!=true){
                    validCells[currentRow-1][currentCol-1]=1;
                }
            }
        }
        return validCells;
    }
    /*below method is used to to printout 2d array representing board and 
       available tiles to move to(5 represent current chose chess piece
       location , 1 if the current tile is available to move to, else 
       if there is a piece of same color available or tile not available
       to move to it will represent 0*/
    public String toString(int[][] arr){
        String m="";
        for(int r=boardSize;r>0;r--){
            for(int c=0;c<boardSize;c++){
                m=m+" "+arr[r][c];
            }
            m=m+"\n";
        }
        return m;
    }
}



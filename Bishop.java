/*this class is used to set the piece name for the bishop piece, as well
   as provide graphics for the piece, and also setting the movement pattern
   for the piece
note:- the movement pattern for this chess piece is decided according to the
empty tiles the piece can move to on the board*/
public class   Bishop extends ChessPiece
{
    private static String pieceName="BISHOP";
    private int boardSize=7;
    Board x=getBoard();
    /* for the methodValid Cells it does detect the valid cells available in whole board , but it only detects them
       diagonally*/
    /*below constructor is used to set the color of the piece, and the
       board in use*/
    public Bishop(String name, String newColor, Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("BishopBlack.png","BishopWhite.png");
    }
    /*below constructor is used to set the color of the piece, it's name,
       and the current board in use*/
    public Bishop(String newColor,Board theBoard){
        super(pieceName,newColor,theBoard);
        setGraphics("BishopBlack.png","BishopWhite.png");
    }
    /*below method is used to set the movement pattern for the bishop
       piece*/
    public boolean isValidMove(int currentRow,int currentCol,int futureRow,int futureCol){
        boolean logic=false;
        int[][] validCells=detectValidCells(currentRow,currentCol);
        for(int r=0;r<validCells.length;r++){
            for(int c=0;c<validCells[0].length;c++){
                if(validCells[r][c]!=1&&futureRow==r && futureCol==c&&futureRow!=currentRow&&futureCol!=currentCol){
                    return true;
                }
            }
        }
        /*below printstatement is useful to imagine how this class 
           movement pattern works*/
        //System.out.println(toString(validCells));
        return logic;
    }
    /*below method is used to detect all the available tiles to move to
       in all the diagonal positive and negative directions*/
    public int[][] detectValidCells(int currentRow,int currentCol){
        int[][] validCells=new int[8][8];
        validCells=initializer(validCells);
        int looper=1;
        int looper2=1;
        int looper3=1;
        int looper4=1;
        /*below for loops is used to iterate through the board in the
           given decided diagonal(either positive or negative)and
           decided if the tile is available to move to*/
        outerloop1:
        for(int r=currentRow+1;r<=boardSize;r++){
            for(int c=currentCol+looper;c<=boardSize;c++){
                boolean sameColor=getColor().equals(x.getPieceColor(r,c));
                validCells[currentRow][currentCol]=7;
                if(x.hasPiece(r,c)&&sameColor){
                    validCells[r][c]=1;
                    looper=looper+1;
                    break outerloop1;
                }
                else if(x.hasPiece(r,c)&&sameColor!=true){
                    validCells[r][c]=0;
                    looper=looper+1;
                    break outerloop1;
                }
                else{
                    validCells[r][c]=5;
                    looper=looper+1;
                    continue outerloop1;
                }
            }
        }
        outerloop2:
        for(int r2=currentRow+1;r2<=boardSize;r2++){
            for(int c2=currentCol-looper2;c2>=0;c2--){
                boolean sameColor=getColor().equals(x.getPieceColor(r2,c2));
                validCells[currentRow][currentCol]=7;
                if(x.hasPiece(r2,c2)&&sameColor){
                    validCells[r2][c2]=1;
                    looper2=looper2+1;
                    break outerloop2;
                }
                else if(x.hasPiece(r2,c2)&&sameColor!=true){
                    validCells[r2][c2]=0;
                    looper2=looper2+1;
                    break outerloop2;
                }
                else{
                    validCells[r2][c2]=5;
                    looper2=looper2+1;
                    continue outerloop2;
                }
            }
        }
        outerloop3:
        for(int r3=currentRow-1;r3>=0;r3--){
            for(int c3=currentCol+looper3;c3<=boardSize;c3++){
                boolean sameColor=getColor().equals(x.getPieceColor(r3,c3));
                validCells[currentRow][currentCol]=7;
                if(x.hasPiece(r3,c3)&&sameColor){
                    validCells[r3][c3]=1;
                    looper3=looper3+1;
                    break outerloop3;
                }
                else if(x.hasPiece(r3,c3)&&sameColor!=true){
                    validCells[r3][c3]=0;
                    looper3=looper3+1;
                    break outerloop3;
                }
                else{
                    validCells[r3][c3]=5;
                    looper3=looper3+1;
                    continue outerloop3;
                }
            }
        }
        outerloop4:
        for(int r4=currentRow-1;r4>=0;r4--){
            for(int c4=currentCol-looper4;c4>=0;c4--){
                boolean sameColor=getColor().equals(x.getPieceColor(r4,c4));
                validCells[r4][c4]=7;
                if(x.hasPiece(r4,c4)&&sameColor){
                    validCells[r4][c4]=1;
                    looper4=looper4+1;
                    break outerloop4;
                }
                else if(x.hasPiece(r4,c4)&&sameColor!=true){
                    validCells[r4][c4]=0;
                    looper4=looper4+1;
                    break outerloop4;
                }
                else{
                    validCells[r4][c4]=5;
                    looper4=looper4+1;
                    continue outerloop4;
                }
            }
        }
        return validCells;
    }
    /*below method is used to printout a 2d to represent the board and the
       available tiles to move to of bishop chess piece
       note:-current piece is represented as 7 on the outputted table
       and empty cells to move to is represented as 5 , and if a piece is 
       present on a tile and can be take out it is represent as 0 ,else 
       if tile is restricted to move to or a piece of same color is available
       it is presented as 1*/
    public String toString(int[][] arr){
        String m="";
        for(int i=7;i>=0;i--){
            for(int x=0;x<arr[0].length;x++){
                m=m+" "+arr[i][x];
            }
            m=m+"\n";
        }
        return m;
    }
    /*below method is used to intialize any 2d array is 1's*/
    public int[][] initializer(int[][] arr){
        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr[0].length;c++){
                arr[r][c]=1;
            }
        }
        return arr;
    }
}

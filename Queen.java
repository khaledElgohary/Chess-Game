/* this class is responsible for setting name of the queen piece , as well
   as providing graphics for the piece , and also set the movement
   pattern of the piece*/
public class Queen extends ChessPiece
{
    private static String pieceName="QUEEN";
    Board x=getBoard();
    private int boardSize=7;
    /*below consturctor is used to set the color of the piece , and 
       the current board in use and also set the graphics for the queen
       piece*/
    public Queen(String name,String newColor,Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("QueenBlack.png","QueenWhite.png");
    }
    /*below constructor is used to set the piece name , as well as the current
       board in use and also set graphics for queen piece*/
    public Queen(String newColor,Board theBoard){
        super(pieceName,newColor,theBoard);
        setGraphics("QueenBlack.png","QueenWhite.png");
    }
    /*below method is used to set the movement pattern for the Queen
       piece*/
    public boolean isValidMove(int currentRow,int currentCol,int futureRow,int futureCol){
        boolean logic=true;
        int blockUp=detectUp(currentRow,currentCol,futureRow,futureCol);
        int blockDown=detectDown(currentRow,currentCol,futureRow,futureCol);
        int blockRight=detectRight(currentRow,currentCol,futureRow,futureCol);
        int blockLeft=detectLeft(currentRow,currentCol,futureRow,futureCol);
        int[][] validCells=detectValidCells(currentRow,currentCol);
        if(futureRow>=blockDown && futureRow<=blockUp &&futureCol>=blockLeft&&futureCol<=blockRight
                &&(futureCol==currentCol||futureRow==currentRow)){
            if(futureRow==currentRow&&futureCol==currentCol){
                logic=false;
            }
            else{
                logic=true;
            }
        }
        else{
            logic=false;
        }
        for(int r=0;r<validCells.length;r++){
            for(int c=0;c<validCells[0].length;c++){
                if(validCells[r][c]!=1&&futureRow==r && futureCol==c&&futureRow!=currentRow&&futureCol!=currentCol){
                    return true;
                }
            }
        }
        return logic;
    }
    /*since the below methods are the same as the castle movement pattern
       ,and the queen also inherits same movement pattern for castle
       , please refer to castle class for explanations of the methods*/
    public int detectUp(int currentRow,int currentCol,int futureRow,int futureCol){
        int currentPos=0;
        int posUp=7;
        for(int i=currentRow+1;i<=boardSize;i++){
            boolean sameColor=getColor().equals(x.getPieceColor(i,currentCol));
            if(x.hasPiece(i,currentCol)&&sameColor){
                posUp=i-1;
                break;
                }
            else if(x.hasPiece(i,currentCol)&&sameColor!=true){
                posUp=i;
                break;
                }
                else{
                posUp=7;
            }
            }  
        if(currentRow==7){
            posUp=7;
        }
        return posUp;
    }
    public int detectDown(int currentRow,int currentCol,int futureRow,int futureCol){
        int currentPos=0;
        int posDown=0;
        for(int i=currentRow-1;i>=0;i--){
            boolean sameColor=getColor().equals(x.getPieceColor(i,currentCol));
            if(x.hasPiece(i,currentCol)&&sameColor){
                posDown=i+1;
                break;
                }
            else if(x.hasPiece(i,currentCol)&&sameColor!=true){
                posDown=i;
                break;
            }
            else{
                posDown=0;
            }
            }
        if(currentRow==0){
            posDown=0;
        }
        return posDown;
    }
    public int detectRight(int currentRow,int currentCol,int futureRow,int futureCol){
        int currentPos=0;
        int posRight=7;
        for(int i=currentCol+1;i<=boardSize;i++){
                currentPos=i;
                boolean sameColor=getColor().equals(x.getPieceColor(currentRow,currentPos));
                if(x.hasPiece(currentRow,i)&&sameColor){
                    posRight=i-1;
                    break;
                }
                else if(x.hasPiece(currentRow,i)&&sameColor!=true){
                    posRight=i;
                    break;
                }
                else{
                    posRight=7;
                }
            }
        if(currentCol==7){
            posRight=7;
        }
        return posRight;
    }
    public int detectLeft(int currentRow,int currentCol,int futureRow,int futureCol){
        int currentPos=0;
        int posLeft=0;
        for(int i=currentCol-1;i>=0;i--){
                boolean sameColor=getColor().equals(x.getPieceColor(currentRow,i));
                if(x.hasPiece(currentRow,i)&&sameColor==true){
                    posLeft=i+1;
                    break;
                }
                else if(x.hasPiece(currentRow,i)&&sameColor==false){
                    posLeft=i;
                    break;
                }
                else{
                    posLeft=0;
                }
            }
        if(currentCol==0){
            posLeft=0;
        }
        return posLeft;
    }
    /*since the queen also inherits same movement pattern as the bishop
       please refer to bishop class for the explanation of the method
       below*/
    public int[][] detectValidCells(int currentRow,int currentCol){
        int[][] validCells=new int[8][8];
        validCells=initializer(validCells);
        int looper=1;
        int looper2=1;
        int looper3=1;
        int looper4=1;
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
        for(int r2=currentRow+1;r2<=boardSize-1;r2++){
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
    /* below method is used to display a table similar to the board , that
       shows the available tiles the board can move to*/
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
    /* below method is used to inititalize the 2d array representing the 
       board with 1*/
    public int[][] initializer(int[][] arr){
        for(int r=0;r<arr.length;r++){
            for(int c=0;c<arr[0].length;c++){
                arr[r][c]=1;
            }
        }
        return arr;
    }
}

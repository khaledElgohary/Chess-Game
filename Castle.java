/*this class is responsible for setting the name of the castle piece, as well
   as providing the graphics for the piece , and also setting the movement
   pattern for the piece
   note:- the movement pattern of this piece is decided according to the 
   bounds surrounding the piece*/
public class Castle extends ChessPiece
{
    private static String pieceName="CASTLE";
    private int boardSize=7;
    Board x=getBoard();
    /*below constructor is used to set the graphics for the castle piece,
       and also set the color of the piece , and current board in use*/
    public Castle(String name,String newColor,Board theBoard){
        super(name,newColor,theBoard);
        setGraphics("CastleBlack.png","CastleWhite.png");
    }
    /*below constructor is used to set the name of the piece,color, and the
       current board in use , as well as provide graphics for the piece*/
    public Castle(String newColor,Board theBoard){
        super(pieceName,newColor,theBoard);
        setGraphics("CastleBlack.png","CastleWhite.png");
    }
    /*below method is used to set the movement pattern for the castle
       piece*/
    public boolean isValidMove(int currentRow,int currentCol,int futureRow,int futureCol){
        boolean logic=true;
        int blockUp=detectUp(currentRow,currentCol,futureRow,futureCol);
        int blockDown=detectDown(currentRow,currentCol,futureRow,futureCol);
        int blockRight=detectRight(currentRow,currentCol,futureRow,futureCol);
        int blockLeft=detectLeft(currentRow,currentCol,futureRow,futureCol);
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
        System.out.println(blockLeft+""+blockRight+""+blockUp+""+blockDown);
        return logic;
    }
    /*below method is used to detect if there is any piece is blocking 
       the path of the castle upward, and also detect if the piece
       can be taken out by the castle or not*/
    public int detectUp(int currentRow,int currentCol,int futureRow,int futureCol){
        int currentPos=0;
        int posUp=7;
        /*below for loop iterate through the board and decide if a piece
           can be taken out or not*/
        for(int i=currentRow+1;i<=boardSize;i++){
            boolean sameColor=getColor().equals(x.getPieceColor(i,currentCol));
            if(x.hasPiece(i,currentCol)&&sameColor){
                posUp=i-1;
                System.out.println("Same");
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
        //if current row is 7 the start position of our bounds is 7
        if(currentRow==7){
            posUp=7;
        }
        return posUp;
    }
    /*below method is used to detect if there is any piece is blocking 
       the path of the castle downward, and also detect if the piece
       can be taken out by the castle or not*/
    public int detectDown(int currentRow,int currentCol,int futureRow,int futureCol){
        int currentPos=0;
        int posDown=0;
        /*below for loop iterate through the board and decide if a piece
           can be taken out or not*/
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
        //if current row is 0 the start position of our bounds is 7
        if(currentRow==0){
            posDown=0;
        }
        return posDown;
    }
    /*below method is used to detect if there is any piece is blocking 
       the path of the castle in the Right side of the piece ,and also 
        detect if the piece can be taken out by the castle or not*/
    public int detectRight(int currentRow,int currentCol,int futureRow,int futureCol){
        int currentPos=0;
        int posRight=7;
        /*below for loop iterate through the board and decide if a piece
           can be taken out or not*/
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
        //if current Col is 7 the start position of our bounds is 7
        if(currentCol==7){
            posRight=7;
        }
        return posRight;
    }
    /*below method is used to detect if there is any piece is blocking 
       the path of the castle in the left side of the piece ,and also 
        detect if the piece can be taken out by the castle or not*/
    public int detectLeft(int currentRow,int currentCol,int futureRow,int futureCol){
        int currentPos=0;
        int posLeft=0;
        /*below for loop iterate through the board and decide if a piece
           can be taken out or not*/
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
        //if current Col is 0 the start position of our bounds is 0
        if(currentCol==0){
            posLeft=0;
        }
        return posLeft;
    }
}

    

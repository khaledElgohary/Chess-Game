import java.io.FileReader;
import java.util.Scanner;
import java.io.BufferedReader;
/* this class is used to load data from a 2d array , that contains string 
   codes */
public class BoardLoader
{
static String chessBoard[][];
static Board board;
static FileReader m;
static String folder ="StandardBoard.txt"; 
/* below statement is used to create new board 
   and also handle the other methods to eventually load piece into the
   created board*/
public static void loadBoardState(Board theBoard, String fileName){
    theBoard=new Board();
    loadPiecesFromString(theBoard,parseFile(fileName));
}
/*below method is used to read data from a file
   and*/
private static String[][] parseFile(String fileName){
    /*since we are trying to input a file from the computer
       we have to put our work in a try catch statement in order
       to catch any exceptions given out*/
    try{
        m=new FileReader(fileName);
        BufferedReader read=new BufferedReader(m);
        Scanner scan=new Scanner(read);
        int row= scan.nextInt();
        int coloumn=scan.nextInt();
        chessBoard=new String[row][coloumn];
        /*below for loop is used to scan through all the 
           string codes in the file and load them into chessBoard
           array*/
        for(int r=0; r<chessBoard.length;r++){
            for(int c=0; c<chessBoard[0].length;c++){
                if(scan.hasNext()==true){
                    chessBoard[r][c]=scan.next();
                }
                else{
                    break;
                }
        }
        }
    }catch(Exception e){
        e.getMessage();
        e.toString();
        e.printStackTrace();
    }

    return chessBoard;
}
/* below method is used to loop through the provided array as parameter
   and according to the code at each location in the board it assigns 
   the tile to it*/
private static void loadPiecesFromString(Board targetBoard,String [][] boardCodes){
    targetBoard=new Board();
    for(int r=0;r<boardCodes.length;r++){
        for(int c=0;c<boardCodes[0].length;c++){
            if(boardCodes[r][c].equals("E")!=true){
            targetBoard.setTile(r,c,loadChessPiece(targetBoard,boardCodes[r][c]));
        }
    }
    }
    targetBoard.drawBoard();
    targetBoard.drawPieces();
}
/*below method is used to create a chess piece according to the string code
   in the string codes array*/
private static ChessPiece loadChessPiece(Board targetBoard,String code){
    ChessPiece piece=new King("WHITE",targetBoard);
    System.out.println("hi "+code); 
    if(code.equals("BP")){
        piece=new Pawn("BLACK",targetBoard);
    }
    else if(code.equals("WP")){
        piece=new Pawn("WHITE",targetBoard);
    }
    else if(code.equals("BC")){
        piece=new Castle("BLACK",targetBoard);
    }
    else if(code.equals("WC")){
        piece=new Castle("WHITE",targetBoard);
    }
    else if(code.equals("BN")){
        piece=new Knight("BLACK",targetBoard);
    }
    else if(code.equals("WN")){
        piece=new Knight("WHITE",targetBoard);
    }
    else if(code.equals("BB")){
        piece=new Bishop("BLACK",targetBoard);
    }
    else if(code.equals("WB")){
        piece=new Bishop("WHITE",targetBoard);
    }
    else if(code.equals("BK")){
        piece=new King("BLACK",targetBoard);
    }
    else if(code.equals("WK")){
        piece=new King("WHITE",targetBoard);
    }
    else if(code.equals("BQ")){
        piece=new Queen("BLACK",targetBoard);
    }
    else if(code.equals("WQ")){
        piece=new Queen("WHITE",targetBoard);
    }
    else {
        System.out.println("no piece");
    }
    return piece;
}
/* below method is used to return string codes array in a form of a table
   similar to the board */
public String toString(){
    String x="";
    String chessBoardL[][]=parseFile(folder);
    for( int r=0;r<chessBoard.length;r++){
        for(int c=0; c<chessBoard[0].length;c++){
            x=x+chessBoard[r][c]+" ";
            if(r>1&&r<6){
                x=x+" ";
            }
        }
        x=x+"\n";
    }
    return x;
}
}


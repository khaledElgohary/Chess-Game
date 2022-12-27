public class BoardLoadTester
{
public static void main(String[] args){
    Board board=new Board();
    BoardLoader.loadBoardState(board,"StandardBoard.txt");
}
}

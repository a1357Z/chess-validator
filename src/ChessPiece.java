import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public abstract class ChessPiece {
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    // if chess piece is dead then row = -1 and col = -1
    int row;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    int column;
    User player;
    ChessBoard board;

    public abstract String getName();

    String name;

    List<List<Vector<Integer>>> directions;

    public ChessPiece(int row, int column, User u, ChessBoard b){
        this.row = row;
        this.column = column;
        this.player = u;
        this.board = b;
        directions = new ArrayList<>();
    }
    public boolean validateMove(int x, int y) {
        boolean answer = false;
        for(List<Vector<Integer>> direction : directions){

//            System.out.println("validating moves for direction: " + direction);
            for(Vector<Integer> d: direction){
                int r = this.row + d.get(0);
                int c = this.column + d.get(1);

//                System.out.println("row: " + r + ", column: " + c);
                // if out of bounds break
                if(r < 0 || r >= this.board.getSize() || c < 0 || c >= this.board.getSize())break;


                // if we encounter a chessPiece of the player making the move, break
                ChessPiece targetPiece = board.getPiece(r,c);
                if(targetPiece != null && targetPiece.getPlayer() == this.player){
                    break;
                }

                // if we encounter an opponent before reaching the target position, break
                if(targetPiece != null && targetPiece.getPlayer() != this.player && (r != x || c != y))break;

                // if we find the index x, y return true
                if(r == x && c == y)return true;

            }
        }
        return answer;
    }
    public User getPlayer(){
        return player;
    };
}

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
    public abstract boolean validateMove(int r, int c);
    public User getPlayer(){
        return player;
    };
}

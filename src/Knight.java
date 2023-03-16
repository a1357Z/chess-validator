import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Knight extends ChessPiece {
    public Knight(int row, int col, User u, ChessBoard b) {
        super(row, col, u, b);
        addDirections();
    }

    private void helper(int x, int y){
        List<Vector<Integer>> d1 = new ArrayList<Vector<Integer>>();
        Vector<Integer> v = new Vector<>();
        v.add(x);v.add(y);
        d1.add(v);
        this.directions.add(d1);
    }

    private void addDirections(){
        //top direction
        helper(-2,-1);
        helper(-2,1);

        // bottom direction
        helper(2,-1);
        helper(2,1);

        // left
        helper(-1,-2);
        helper(1,-2);

        //  right
        helper(-1,2);
        helper(1,2);
    }

    @Override
    public String getName() {
        return "Knight";
    }
}

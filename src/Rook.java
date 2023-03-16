import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Rook extends ChessPiece {
    public Rook(int row, int column, User u, ChessBoard b) {
        super(row, column, u, b);
        addDirections();
    }

    @Override
    public String getName() {
        return "Rook";
    }

    private void addDirections(){
        int x = 0, y = 0;
        int count = 0;
        List<Vector<Integer>> d1 = new ArrayList<Vector<Integer>>();

        //top direction
        while(count < this.board.getSize()){
            x--;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d1.add(v);
        }
        this.directions.add(d1);

        // bottom direction
        List<Vector<Integer>> d2 = new ArrayList<Vector<Integer>>();
        x=0;
        count = 0;
//        direction.clear();
        while(count < this.board.getSize()){
            x++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d2.add(v);
        }
        this.directions.add(d2);

        // left
        List<Vector<Integer>> d3 = new ArrayList<Vector<Integer>>();
        x=0;
        count = 0;
//        direction.clear();
        while(count < this.board.getSize()){
            y--;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d3.add(v);
        }
        this.directions.add(d3);

        //  right
        List<Vector<Integer>> d4 = new ArrayList<Vector<Integer>>();
        y=0;
        count = 0;
//        direction.clear();
        while(count < this.board.getSize()){
            y++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d4.add(v);
        }
        this.directions.add(d4);


    }

}

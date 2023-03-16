import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Bishop extends ChessPiece {
    @Override
    public String getName() {
        return "Bishop";
    }

    public Bishop(int row, int column, User u, ChessBoard b){
        super(row, column, u, b);
        addDirections();
    }

    private void addDirections(){
        int x = 0, y = 0;
        int count = 0;
        List<Vector<Integer>> d1 = new ArrayList<Vector<Integer>>();

        //top left direction
        while(count < this.board.getSize()){
            x--;y--;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d1.add(v);
        }
        this.directions.add(d1);

        // top right
        List<Vector<Integer>> d2 = new ArrayList<Vector<Integer>>();
        x=0;y=0;
        count = 0;
//        direction.clear();
        while(count < this.board.getSize()){
            x--;y++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d2.add(v);
        }
        this.directions.add(d2);

        // bottom left
        List<Vector<Integer>> d3 = new ArrayList<Vector<Integer>>();
        x=0;y=0;
        count = 0;
//        direction.clear();
        while(count < this.board.getSize()){
            x++;y--;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d3.add(v);
        }
        this.directions.add(d3);

        // bottom right
        List<Vector<Integer>> d4 = new ArrayList<Vector<Integer>>();
        x=0;y=0;
        count = 0;
//        direction.clear();
        while(count < this.board.getSize()){
            x++;y++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d4.add(v);
        }
        this.directions.add(d4);


    }

    public static void main(String[] args){

    }
}

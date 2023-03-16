import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class King extends ChessPiece {
    public King(int row, int column, User u, ChessBoard b) {
        super(row, column, u, b);
        addDirections();
    }

    private void addDirections(){
        int x = 0, y = 0;
        int count = 0;
        List<Vector<Integer>> d1 = new ArrayList<Vector<Integer>>();

        //top direction
        while(count < 1){
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
        while(count < 1){
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
        while(count < 1){
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
        while(count < 1){
            y++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d4.add(v);
        }
        this.directions.add(d4);

        // bishop directions

        List<Vector<Integer>> d5 = new ArrayList<Vector<Integer>>();

        count = 0; y = 0;
        //top left direction
        while(count < 1){
            x--;y--;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d5.add(v);
        }
        this.directions.add(d5);

        // top right
        List<Vector<Integer>> d6 = new ArrayList<Vector<Integer>>();
        x=0;y=0;
        count = 0;
//        direction.clear();
        while(count < 1){
            x--;y++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d6.add(v);
        }
        this.directions.add(d6);

        // bottom left
        List<Vector<Integer>> d7 = new ArrayList<Vector<Integer>>();
        x=0;y=0;
        count = 0;
//        direction.clear();
        while(count < 1){
            x++;y--;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d7.add(v);
        }
        this.directions.add(d7);

        // bottom right
        List<Vector<Integer>> d8 = new ArrayList<Vector<Integer>>();
        x=0;y=0;
        count = 0;
//        direction.clear();
        while(count < 1){
            x++;y++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            d8.add(v);
        }
        this.directions.add(d8);
    }


    @Override
    public String getName() {
        return "King";
    }
}

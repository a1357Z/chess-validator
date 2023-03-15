import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Rook extends ChessPiece {
    public Rook(int row, int column, User u, ChessBoard b) {
        super(row, column, u, b);
        addDirections();
    }

    @Override
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

    @Override
    public User getPlayer() {
        return player;
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

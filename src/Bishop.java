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
        List<Vector<Integer>> direction = new ArrayList<Vector<Integer>>();

        //top left direction
        while(count < this.board.getSize()){
            x--;y--;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            direction.add(v);
        }
        this.directions.add(direction);

        // top right
        x=0;y=0;
        count = 0;
        direction.clear();
        while(count < this.board.getSize()){
            x--;y++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            direction.add(v);
        }
        this.directions.add(direction);

        // bottom left
        x=0;y=0;
        count = 0;
        direction.clear();
        while(count < this.board.getSize()){
            x++;y--;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            direction.add(v);
        }
        this.directions.add(direction);

        // bottom right
        x=0;y=0;
        count = 0;
        direction.clear();
        while(count < this.board.getSize()){
            x++;y++;
            count++;
            Vector<Integer> v = new Vector<>();
            v.add(x);v.add(y);
            direction.add(v);
        }
        this.directions.add(direction);


    }

    @Override
    public boolean validateMove(int x, int y) {
        boolean answer = false;
        for(List<Vector<Integer>> direction : directions){
            for(Vector<Integer> d: direction){
                int r = this.row + d.get(0);
                int c = this.column + d.get(1);

                // if out of bounds break
                if(r < 0 || r >= this.board.getSize() || c < 0 || c >= this.board.getSize())break;

                // if we encounter a chessPiece of the player making the move, break
                ChessPiece targetPiece = board.getPiece(r,c);
                if(targetPiece != null && targetPiece.getPlayer() == this.player){
                    break;
                }

                // if we find the index x, y return true
                if(r == x && c == y)return true;

            }
        }
        return answer;
    }

    @Override
    public User getPlayer() {
        return this.player;
    }
}

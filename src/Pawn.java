public class Pawn extends ChessPiece{
    DIRECTION d;
    boolean twoStepsMoved = false;
    public Pawn(int row, int column, User u, ChessBoard b) {
        super(row, column, u, b);
        if(u.getId() == 0){
            d = DIRECTION.DOWN;
        }else{
            d = DIRECTION.UP;
        }


    }

    @Override
    public boolean validateMove(int x, int y) {


        if(this.d == DIRECTION.DOWN){
            int r = row + 1;

            //left move
            int c = column - 1;
            if(r == x && c == y && board.getPiece(x,y)!= null && board.getPiece(x,y).getPlayer() != player){
                return true;
            }

            //right move
            c = column + 1;
            if(r == x && c == y && board.getPiece(x,y)!= null && board.getPiece(x,y).getPlayer() != player){
                return true;
            }

            //one step down
            c = column;
            if(r == x && c == y && board.getPiece(x,y) == null){
                return true;
            }

            //two steps down
            r++;
            if(r == x && c == y && board.getPiece(x,y) == null && board.getPiece(x-1,y) == null && !twoStepsMoved){
                twoStepsMoved = true;
                return true;
            }

            return false;
        }else{
            int r = row - 1;

            //left move
            int c = column - 1;
            if(r == x && c == y && board.getPiece(x,y)!= null && board.getPiece(x,y).getPlayer() != player){
                return true;
            }

            //right move
            c = column + 1;
            if(r == x && c == y && board.getPiece(x,y)!= null && board.getPiece(x,y).getPlayer() != player){
                return true;
            }

            //one step up
            c = column;
            if(r == x && c == y && board.getPiece(x,y) == null){
                return true;
            }

            //two steps up
            r--;
            if(r == x && c == y && board.getPiece(x,y) == null && board.getPiece(x+1,y) == null && !twoStepsMoved){
                twoStepsMoved = true;
                return true;
            }

            return false;
        }
    }

    @Override
    public String getName() {
        return "Pawn";
    }
}

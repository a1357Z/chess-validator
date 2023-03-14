public class King extends ChessPiece {
    public King(int row, int column, User u, ChessBoard b) {
        super(row, column, u, b);
    }

    @Override
    public boolean validateMove(int r, int c) {
        return false;
    }

    @Override
    public User getPlayer() {
        return null;
    }

    @Override
    public String getName() {
        return "King";
    }
}

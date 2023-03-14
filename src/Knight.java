public class Knight extends ChessPiece {
    public Knight(int row, int col, User u, ChessBoard b) {
        super(row, col, u, b);
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
        return "Knight";
    }
}

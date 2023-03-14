import java.util.ArrayList;
import java.util.List;

public class ChessBoard {
    int size = 8;
    List<ChessPiece> pieces;
    User currentPlayer;
    User p1, p2;
//    whether the slot is occupied or not
//    when a player arrives we assign the empty slot to him
    boolean slot1Assigned = false;

    public ChessBoard(User u1, User u2){
        p1 = u1;
        p2 = u2;
        currentPlayer = u1;
        pieces = new ArrayList<>();
        addPieces(u1);
        addPieces(u2);
    }

    private int getVacantRow(){
        int rowIdx;
        if(!slot1Assigned){
            rowIdx = 0;
        }else{
            rowIdx = 7;
        }
        return rowIdx;
    }

    private int getPawnRow(int generalsRow){
        if(generalsRow == 0)return 1;
        return 6;
    }

    private void addPieces(User u){
        int row = getVacantRow();

        // add generals
        for(int col = 0;col < 8; col++){
            // create a chess piece
            ChessPiece p = null;
            if(col == 0 || col == 7){
                p = new Bishop(row, col, u, this);
//                p = new Rook(row, col, u, this);
            }else if( col == 1 || col == 6){
                p = new Bishop(row, col, u, this);
//                p = new Knight(row, col, u, this);
            }else if(col == 2 || col == 5){
                p = new Bishop(row, col, u, this);
            }else if(col == 3){
                p = new Bishop(row, col, u, this);
//                p = new Queen(row, col, u, this);
            }else{
                p = new Bishop(row, col, u, this);
//                p = new King(row, col, u, this);
            }

            // append the piece to the list
            this.pieces.add(p);
        }

        // add pawns
        // int pawnRow = getPawnRow(row);



    }

    public int getSize() {
        return 8;
    }

    public ChessPiece getPiece(int r, int c){
        for(ChessPiece p: pieces){
            // skip the dead pieces
            if(p.getColumn() == -1 && p.getRow() == -1)continue;

            //find a piece with a matching sRow and sCol
            if( p.getRow() == r && p.getColumn() == c)return p;
        }
        return null;
    }

    boolean invalidCell(int r, int c){
        return r < 0 || r >= 8 || c < 0 || c >= 8;
    }

    public void makeMove(int sRow, int sCol, int eRow, int eCol){

        //check for invalid cells
        if(invalidCell(sRow, sCol) || invalidCell(eRow, eCol)){
            System.out.println("Some invalid cell selected");
            return;
        }

        ChessPiece currentPiece = getPiece(sRow, sCol);

        // if no piece found print empty cell selected
        if(currentPiece == null){
            System.out.println("Empty initial cell selected");
            return;
        }

        // if piece of opponent found, print cannot move enemy piece
        if(currentPiece.getPlayer() != currentPlayer){
            System.out.println("Cannot move enemy piece");
            return;
        }

        // ask the found piece to validate move
        boolean validMove = currentPiece.validateMove(eRow, eCol);

        // if move is invalid, print invalid move
        if(!validMove){
            System.out.println("Invalid move");
            return;
        }

        // make move

        // change the position of the currentPiece
        currentPiece.setRow(eRow);
        currentPiece.setColumn(eCol);
        System.out.println(currentPiece.getName() + "made the move");

        ChessPiece targetPiece = this.getPiece(eRow,eCol);
        if(targetPiece != null){
            // kill the targetPiece
            targetPiece.setRow(-1);
            targetPiece.setColumn(-1);
            System.out.println(targetPiece.getName() + "of the opponent was killed");
        }

        // update the currentPlayer
        if(currentPlayer == p1){
            currentPlayer = p2;
        }else{
            currentPlayer = p1;
        }


    }

    public void printBoard(){

    }
}

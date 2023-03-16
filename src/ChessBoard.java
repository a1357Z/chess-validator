import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

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

        printBoard();
    }

    public int getCurrentPlayer() {
        return currentPlayer.getId();
    }

    private int getVacantRow(){
        int rowIdx;
        if(!slot1Assigned){
            rowIdx = 0;
            slot1Assigned = true;
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
//                p = new Bishop(row, col, u, this);
                p = new Rook(row, col, u, this);
            }else if( col == 1 || col == 6){
//                p = new Bishop(row, col, u, this);
                p = new Knight(row, col, u, this);
            }else if(col == 2 || col == 5){
                p = new Bishop(row, col, u, this);
            }else if(col == 3){
//                p = new Bishop(row, col, u, this);
                p = new Queen(row, col, u, this);
            }else{
//                p = new Bishop(row, col, u, this);
                p = new King(row, col, u, this);
            }

            // append the piece to the list
            this.pieces.add(p);
        }

        // add pawns
        int pawnRow = getPawnRow(row);
        for(int col=0;col < 8; col++){
            ChessPiece p = new Pawn(pawnRow, col, u, this);
            this.pieces.add(p);
        }


    }

    public int getSize() {
        return 8;
    }

    public void printPieces(){
        System.out.println("Printing chess pieces: ");
        for(ChessPiece p: pieces){
            // skip the dead pieces
            System.out.println("row: " + p.getRow() + ", column: " + p.getColumn());
        }
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

    public boolean makeMove(int sRow, int sCol, int eRow, int eCol){
//        printPieces();
        boolean gameOver = false;
        //check for invalid cells
        if(invalidCell(sRow, sCol) || invalidCell(eRow, eCol)){
            System.out.println("Some invalid cell selected");
            return gameOver;
        }

        ChessPiece currentPiece = getPiece(sRow, sCol);

        // if no piece found print empty cell selected
        if(currentPiece == null){
            System.out.println("Empty initial cell selected");
            return gameOver;
        }

        // if piece of opponent found, print cannot move enemy piece
        if(currentPiece.getPlayer() != currentPlayer){
            System.out.println("Cannot move enemy piece");
            return gameOver;
        }

        // ask the found piece to validate move
        boolean validMove = currentPiece.validateMove(eRow, eCol);

        // if move is invalid, print invalid move
        if(!validMove){
            System.out.println("Invalid move");
            return gameOver;
        }

        // make move
        ChessPiece targetPiece = this.getPiece(eRow,eCol);
        if(targetPiece != null){
            // kill the targetPiece
            targetPiece.setRow(-1);
            targetPiece.setColumn(-1);
            System.out.println(targetPiece.getName()+ " at row: " + eRow + ", col: " + eCol + ", of the opponent was killed");

            if(Objects.equals(targetPiece.getName(), "King")){
                System.out.println("Player: " + currentPlayer.getId() + " won the game!!");
                gameOver = true;
                return gameOver;
            }
        }

        // change the position of the currentPiece
        currentPiece.setRow(eRow);
        currentPiece.setColumn(eCol);
        System.out.println(currentPiece.getName() + " at row: " + sRow + ", col: " + sCol   + ", made the move to " + "row: " + eRow + ", col: " + eCol);

        // update the currentPlayer
        if(currentPlayer == p1){
            currentPlayer = p2;
        }else{
            currentPlayer = p1;
        }

        printBoard();
        return gameOver;

    }

    public void printBoard(){

        //build default board config
        Vector<Vector<String>> b = new Vector<>();
        for(int i=0;i<8;i++){
            Vector<String> r = new Vector<>();
            for(int j=0;j<8;j++){
                r.add("--");
            }
            b.add(r);
        }

        // add the elements positions
        for(ChessPiece p: pieces){
            // skip the dead pieces
            if(p.getColumn() == -1 && p.getRow() == -1)continue;

            int r = p.getRow();
            int c = p.getColumn();
            b.get(r).set(c, String.valueOf(p.getPlayer().getId()) + p.getName().charAt(0));
        }

        // print the board
        //print the columns
        System.out.print( "0 ");
        for(int i=0;i<8;i++){
            System.out.print("0" + i + " ");
        }
        System.out.println(" ");

        for(int i=0;i<8;i++){
            // print row number
            System.out.print(i + " ");
            for(int j=0;j<8;j++){
                System.out.print(b.get(i).get(j) + " ");
            }
            System.out.println(" ");
        }
    }
}

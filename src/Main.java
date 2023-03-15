import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User user1 = new User(0);
        User user2 = new User(1);

        ChessBoard board = new ChessBoard(user1, user2);
        System.out.println("Welcome to the chess game!!");
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Current Player Id: " + board.getCurrentPlayer());
            System.out.println("enter row of chessPiece u want to move or -1 to abort game");
            int sRow = Integer.parseInt(scanner.nextLine());

            if(sRow == -1){
                System.out.println("Game aborted");
                break;
            }

            System.out.println("enter column of chessPiece u want to move");
            int sCol = Integer.parseInt(scanner.nextLine());

            System.out.println("enter target row");
            int eRow = Integer.parseInt(scanner.nextLine());
            System.out.println("enter target column");
            int eCol = Integer.parseInt(scanner.nextLine());

            board.makeMove(sRow, sCol, eRow, eCol);
        }
    }
}
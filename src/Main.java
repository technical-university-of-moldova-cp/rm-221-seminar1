import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] board = new char[] {'1','2','3',
                                   '4','5','6',
                                   '7','8','9' };
        DisplayTable(board);
        for (int i = 0; i < 9; i++) {
            char player = 'x';
            if(i%2 != 0){
               player = 'o';
            }
            int coordinate = 0;
            while (coordinate < 1 || 9 < coordinate) {
                System.out.print("Get coordinate: ");
                coordinate = scanner.nextInt();
                if (coordinate > 9 || coordinate < 1) {
                    System.out.println("Coordinate out of bounds.(Range 1-9)");
                }
                else if(board[coordinate-1]=='x' || board[coordinate-1]=='o'){
                    System.out.println("Position is occupied");
                    coordinate = 0;
                }
            }
            board[coordinate - 1] = player;
            DisplayTable(board);
            if((board[0] == player && board[1] == player && board[2] == player)
            || (board[3] == player && board[4] == player && board[5] == player)
            || (board[6] == player && board[7] == player && board[8] == player)
            || (board[0] == player && board[3] == player && board[6] == player)
            || (board[1] == player && board[4] == player && board[7] == player)
            || (board[2] == player && board[5] == player && board[8] == player)
            || (board[0] == player && board[4] == player && board[8] == player)
            || (board[2] == player && board[4] == player && board[6] == player)
            ){
                System.out.println("Player " + player + " Won");
                break;
            }
        }
    }
    static void DisplayTable(char[] board){
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i]);
            if ((i + 1) % 3 == 0)
                System.out.println();
        }
    }
}
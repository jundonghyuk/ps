
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static char[][] board = new char[4000][7000];

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        for (int i = 0; i < N; i++) {
            Arrays.fill(board[i], ' ');
        }
        printStart(0,N-1, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i  <N; i++) {
            for (int j = 0 ; j < 2 * N -1;j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void printStart(int row, int col, int height) {
        if (height == 3) {
            board[row][col] = '*';
            board[row + 1][col - 1] = '*';
            board[row + 1][col + 1] = '*';
            for (int i = 0; i < 5; i++) {
                board[row + 2][col - 2 + i] = '*';
            }
            return;
        }

        printStart(row, col, height/ 2);
        printStart(row + height /2, col - height/2 , height/2);
        printStart(row + height /2, col + height/2 , height/2);
    }
}

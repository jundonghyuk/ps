
import java.util.Scanner;

public class Main {

    static int N;
    static int ret;
    static boolean[][] board = new boolean[15][15];

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        nQueen(0);
        System.out.println(ret);
    }

    public static void nQueen(int row) {
        if (row == N) {
            ret++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (existsSameColumn(i) || existsSameDiagonal(row, i)) {
                continue;
            }
            board[row][i] = true;
            nQueen(row + 1);
            board[row][i] = false;
        }
    }

    public static boolean existsSameColumn(int column) {
        for (int i = 0; i < N; i++) {
            if (board[i][column]) {
                return true;
            }
        }
        return false;
    }

    public static boolean existsSameDiagonal(int row, int col) {
        for (int i = 0; row - i >= 0; i++) {
            if (col - i < 0) {
                break;
            }
            if (board[row - i][col - i]) {
                return true;
            }
        }

        for (int i = 0; row - i >= 0; i++) {
            if (col + i >= N) {
                break;
            }
            if (board[row - i][col + i]) {
                return true;
            }
        }
        return false;
    }
}

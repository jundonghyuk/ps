
import java.util.Scanner;

public class Main {

    static int N;
    static char[][] board = new char[2500][2500];

    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '*';
            }
        }
        pointStar(0, 0, N);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void pointStar(int row, int col, int size) {
        if (size == 1) {
            return;
        }
        int nextSize = size / 3;
        int startRow = row + nextSize;
        int startCol = col + nextSize;

        for (int i = startRow; i < startRow + nextSize; i++) {
            for (int j = startCol; j < startCol + nextSize; j++) {
                board[i][j] = ' ';
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pointStar(row + i * nextSize, col + j * nextSize, nextSize);
            }
        }
    }
}

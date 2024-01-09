
import java.util.Scanner;

/*
    16:15 ~
    시간 복잡도 4(UDRL)^5 * 20 * 20 * 20 = 1024 * 400 * 20 =
    1. 블럭을 이동시킨다
    2. 블럭을 합친다
 */
public class Main {

    static int N;
    static int[][] board = new int[21][21];
    static boolean[][] hit;
    static int ret;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        rec(0, board);
        System.out.println(ret);
    }

    public static void rec(int depth, int[][] board) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    ret = Math.max(board[i][j], ret);
//                    System.out.print(board[i][j] + " ");
                }
//                System.out.println();
            }
//            System.out.println();
            return;
        }

        int[][] nextBoard = rotate(board);
        move(nextBoard);
        rec(depth + 1, nextBoard);

        nextBoard = rotate(rotate(board));
        move(nextBoard);
        rec(depth + 1, nextBoard);

        nextBoard = rotate(rotate(rotate(board)));
        move(nextBoard);
        rec(depth + 1, nextBoard);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nextBoard[i][j] = board[i][j];
            }
        }
        move(nextBoard);
        rec(depth + 1, nextBoard);
    }

    public static void move(int[][] board) {
        hit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                int nextY = j - 1;
                while (nextY >= 0 && board[i][nextY] == 0) {
                    nextY--;
                }
                if (nextY == -1) {
                    board[i][0] = board[i][j];
                    board[i][j] = 0;
                } else if(board[i][nextY] == board[i][j] && !hit[i][nextY]) {
                    board[i][nextY] *= 2;
                    board[i][j] = 0;
                    hit[i][nextY] = true;
                } else {
                    int temp = board[i][j];
                    board[i][j] = 0;
                    board[i][nextY + 1] = temp;
                }
            }
        }
    }

    public static int[][] rotate(int[][] original) {
        int[][] temp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = original[N - j - 1][i];
            }
        }
        return temp;
    }
}

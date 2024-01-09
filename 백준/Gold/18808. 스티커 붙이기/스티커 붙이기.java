
import java.util.Scanner;

/*
        1. 맞는지 확인
        2. 회전
        15:55 ~
 */
public class Main {

    static int ret;
    static int N, M, K;
    static int R, C;
    static boolean[][] sticker = new boolean[15][15];
    static boolean[][] board = new boolean[41][41];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        while (K-- > 0) {
            R = sc.nextInt();
            C = sc.nextInt();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    sticker[i][j] = sc.nextInt() == 1;
                }
            }

            for (int turn = 0; turn < 4; turn++) {
                boolean success = false;
                for (int i = 0; i <= N - R; i++) {
                    for (int j = 0; j <= M - C; j++) {
                        if (isMatch(i, j)) {
                            success = true;
                            break;
                        }
                    }
                    if (success) {
                        break;
                    }
                }
                if (success) {
                    break;
                } else {
                    rotate();
                }
            }
        }
        System.out.println(ret);
    }

    public static boolean isMatch(int x, int y) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j] && board[x + i][y + j]) {
                    return false;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (sticker[i][j]) {
                    board[x + i][y + j] = true;
                    ret++;
                }
            }
        }
        return true;
    }

    public static void rotate() {
        boolean[][] temp = new boolean[15][15];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                temp[i][j] = sticker[i][j];
            }
        }

        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                sticker[i][j] = temp[R - 1 - j][i];
            }
        }
        int rot = C;
        C = R;
        R = rot;
    }
}


import java.util.Scanner;

public class Main {

    static int N;
    static int[][] board;
    static int nextX, nextY;
    static boolean[] rightDownDiagonal = new boolean[50];
    static int[] rightDown = new int[50];
    static boolean[] rightUpDiagonal = new boolean[50];
    static int[] rightUp = new int[50];
    static int ret;
    static int retSum;
    static int bishop;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    rightUp[i + j]++;
                    rightDown[N + i - j - 1]++;
                }
            }
        }
        findBishopPosition(0, 0);
        retSum += ret;
        ret= 0;
        findBishopPosition(0, 1);
        System.out.println(retSum + ret);

    }

    public static void findBishopPosition(int x, int y) {
        if (x == N && y >= 0) {
            ret = Math.max(ret, bishop);
            return;
        }

        if (board[x][y] == 0) {
            findNextPosition(x, y);
            findBishopPosition(nextX, nextY);
            return;
        }
        if (canRightDownDiagonal(x, y) && canRightUpDiagonal(x, y)) {
            rightUpDiagonal[x + y] = true;
            rightUp[x + y]--;
            rightDownDiagonal[N + x - y - 1] = true;
            rightDown[N + x - y - 1]--;
            bishop++;
            findNextPosition(x, y);
            findBishopPosition(nextX, nextY);
            bishop--;
            rightDown[N + x - y - 1]++;
            rightDownDiagonal[N + x - y - 1] = false;
            rightUp[x + y]++;
            rightUpDiagonal[x + y] = false;
            if (rightDown[N + x - y - 1] + rightUp[x + y] != 1) {
                findNextPosition(x, y);
                findBishopPosition(nextX, nextY);
            }
        } else {
            findNextPosition(x, y);
            findBishopPosition(nextX, nextY);
        }
    }

    public static void findNextPosition(int x, int y) {
        if(N % 2 == 0) {
            if(y == N-1) {
                nextX = x + 1;
                nextY = 0;
            } else if(y == N-2) {
                nextX = x + 1;
                nextY = 1;
            } else {
                nextX = x;
                nextY = y + 2;
            }
        } else {
            if(y == N-1) {
                nextX = x + 1;
                nextY = 1;
            } else if(y == N-2) {
                nextX = x + 1;
                nextY = 0;
            } else {
                nextX = x;
                nextY = y + 2;
            }
        }
    }

    public static boolean canRightUpDiagonal(int x, int y) {
        return !rightUpDiagonal[x + y];
    }

    public static boolean canRightDownDiagonal(int x, int y) {
        return !rightDownDiagonal[N + x - y - 1];
    }
}

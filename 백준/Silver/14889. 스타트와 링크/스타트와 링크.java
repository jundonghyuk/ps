
import java.util.Scanner;

/*
        3:20 ~
 */
public class Main {

    static int n;
    static int[][] board = new int[21][21];
    static boolean[] arr = new boolean[21];
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        rec(0, 0);
        System.out.println(ret);
    }

    public static void rec(int depth, int cur) {
        if (depth == n / 2) {
            ret = Math.min(ret, calculate());
            return;
        }

        for (int i = cur; i < n; i++) {
            arr[i] = true;
            rec(depth + 1, i + 1);
            arr[i] = false;
        }
    }

    public static int calculate() {
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] && arr[j]) {
                    a += board[i][j];
                    a += board[j][i];
                } else if (!arr[i] && !arr[j]) {
                    b += board[i][j];
                    b += board[j][i];
                }
            }
        }
        return Math.abs(a - b);
    }
}

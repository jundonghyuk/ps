
import java.util.Scanner;

public class Main {
    static int n, k;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int w = arr[i][0];
            int v = arr[i][1];
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - w >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w] + v);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}

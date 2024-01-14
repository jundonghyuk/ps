
import java.util.Scanner;

/*
        7:11 ~
        1. dp[i][j][k] i시간에 j이동 k
        2. dp[i][j] =
 */
public class Main {

    static int t, w;
    static int[] arr = new int[1001];
    static int[][][] dp = new int[1001][31][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        w = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 1; i <= t; i++) {
            dp[i][0][1] = dp[i-1][0][1]+ (arr[i] == 1 ? 1:0);
            for (int j = 1; j <= w; j++) {
                if(arr[i] == 1) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);
                } else {
                    dp[i][j][1] = Math.max(dp[i-1][j-1][2], dp[i-1][j][1]);
                    dp[i][j][2] = Math.max(dp[i-1][j-1][1], dp[i-1][j][2]) + 1;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i <= w; i++) {
            ret = Math.max(ret, Math.max(dp[t][i][1], dp[t][i][2]));
        }
        System.out.println(ret);
    }
}

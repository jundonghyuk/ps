
import java.util.Arrays;
import java.util.Scanner;

/*
        12:23 ~
 */
public class Main {

    static int n, k;
    static int[] coin;
    static int[][] dp;
    /*
            dp[i][j] -> i번째 동전까지 사용하여 j원을 만들 때 최소 필요 동전 개수
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        coin = new int[n + 1];
        dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            coin[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k ; j++) {
                dp[i][j] = 10001;
            }
        }
        Arrays.sort(coin);
        int num = coin[1];
        while(num <= k) {
            dp[1][num] = dp[1][num - coin[1]] + 1;
            num += coin[1];
        }
        for (int i = 2; i <= n; i++) {
            int val = coin[i];
            for (int j = 1; j <= k; j++) {
                if(j == val) {
                    dp[i][j] = 1;
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
                if (j - val >= 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-val] + 1);
                }
            }
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= k ; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(dp[n][k] == 10001 ? -1 : dp[n][k]);
    }
}

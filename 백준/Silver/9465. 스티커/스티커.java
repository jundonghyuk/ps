
import java.util.Scanner;

/*
4:44
 */
public class Main {

    static int[][] arr;
    static int t, n;
    /*
    dp[i][j] = (i,j)를 떼었을 때 최대
     */
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            arr = new int[2][n];
            dp = new int[2][n];
            for (int i = 0; i < n; i++) {
                arr[0][i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arr[1][i] = sc.nextInt();
            }
            if(n == 1) {
                System.out.println(Math.max(arr[0][0], arr[1][0]));
                continue;
            }
            dp[0][0] = arr[0][0];
            dp[1][0] = arr[1][0];
            dp[0][1] = arr[1][0] + arr[0][1];
            dp[1][1] = arr[0][0] + arr[1][1];
            for (int i = 2; i < n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + arr[0][i];
                dp[1][i] = Math.max(dp[0][i-1], Math.max(dp[0][i-2], dp[1][i-2])) + arr[1][i];
            }

            System.out.println(
                    Math.max(dp[0][n-2],
                            Math.max(dp[1][n-2],
                                    Math.max(dp[0][n-1], dp[1][n-1]))));
        }
    }
}

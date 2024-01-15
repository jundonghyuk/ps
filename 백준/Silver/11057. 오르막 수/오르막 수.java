
import java.util.Scanner;

/*
        5:02 ~
        dp[i][j] : i자리수 숫자 중 j로 끝나는 오르막수의 개수
 */
public class Main {

    static int[][] dp = new int[1001][10];
    static int n;
    static long sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k<= j; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
            sum %= 10007;
        }
        System.out.println(sum);
    }
}

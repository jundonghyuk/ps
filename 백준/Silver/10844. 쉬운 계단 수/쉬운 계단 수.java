import java.util.Scanner;

public class Main {
    static int[][] dp;
    static int mod = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[101][10];

        dp[1][0] = 0;
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }
        int sum = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j != 0) {
                    dp[i][j - 1] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
                }
                if (j != 9) {
                    dp[i][j + 1] = (dp[i][j + 1] + dp[i - 1][j]) % mod;
                }
            }
        }

        for (int i = 0; i <= 9; i++) {
            sum = (sum + dp[N][i]) % mod;
        }

        System.out.println(sum);
    }
}

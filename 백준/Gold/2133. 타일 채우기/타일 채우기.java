
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        int[] dp = new int[40];

        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 4; i - j >= 0; j = j + 2) {
                dp[i] = dp[i] + 2 * dp[i - j];
            }
        }
        System.out.println(dp[n]);
    }
}

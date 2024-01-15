
import java.util.Scanner;

public class Main {
    static int t, n;
    static long[] dp = new long[1000001];
    static long mod = 1000000009;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for (int i = 4; i <= n; i++) {
                if (dp[i] != 0) continue;
                dp[i] = ((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;
            }
            System.out.println(dp[n] % mod);
        }
    }
}

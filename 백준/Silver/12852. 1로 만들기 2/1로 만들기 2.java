
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] memo = new int[1000001];
    static int[] dp = new int[1000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            memo[i] = i -1;
            if (i % 2 == 0 && dp[i / 2] < dp[i]) {
                dp[i] = dp[i / 2] + 1;
                memo[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i / 3] < dp[i]) {
                dp[i] = dp[i / 3] + 1;
                memo[i] = i / 3;
            }
        }
        System.out.println(dp[n]);
        StringBuilder sb = new StringBuilder();
        int i = n;
        while (true) {
            sb.append(i);
            sb.append(" ");
            if (i == 1) {
                break;
            }
            i = memo[i];
        }
        System.out.println(sb);
    }
}

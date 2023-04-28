import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            if (dp[i] == -1) {
                int minNum = Integer.MAX_VALUE;
                if(i % 3 == 0) {
                    minNum = Math.min(minNum, dp[i / 3]);
                }
                if(i % 2 == 0 ) {
                    minNum = Math.min(minNum, dp[i / 2]);
                }
                int minusOne = i - 1;
                minNum = Math.min(minNum, dp[minusOne]);
                dp[i] = minNum + 1;
            }
        }
        System.out.println(dp[N]);
    }
}


// 10:32
class Solution {
    public static int solution(int n) {
        long[] dp = new long[5001];

        if (n % 2 == 1) {
            return 0;
        }
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 3;
        long sum = 0;
        for (int i = 4; i <= n; i = i + 2) {
            sum = (sum + dp[i - 4]) % 1000000007;
            dp[i] = (dp[i - 2] * 3 + sum * 2) % 1000000007;
        }
        return (int) dp[n];
    }
}

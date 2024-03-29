
// 2:31 ~
class Solution {
    static int[] dp = new int[2001];

    public static long solution(int n) {
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % 1234567 + dp[i - 2] % 1234567) % 1234567;
        }
        return dp[n];
    }
}

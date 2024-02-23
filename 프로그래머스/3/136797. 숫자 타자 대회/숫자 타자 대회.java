import java.util.*;

class Solution {
    static int[][] board = {
        {1, 2, 4, 2, 3, 5, 4, 5, 6, 7},
        {2, 1, 2, 3, 2, 3, 5, 4, 5, 6},
        {4, 2, 1, 5, 3, 2, 6, 5, 4, 7},
        {2, 3, 5, 1, 2, 4, 2, 3, 5, 5},
        {3, 2, 3, 2, 1, 2, 3, 2, 3, 4},
        {5, 3, 2, 4, 2, 1, 5, 3, 2, 5},
        {4, 5, 6, 2, 3, 5, 1, 2, 4, 3},
        {5, 4, 5, 3, 2, 3, 2, 1, 2, 2},
        {6, 5, 4, 5, 3, 2, 4, 2, 1, 3},
        // {6, 7, 8, 4, 5, 6, 2, 3, 5, 1, 2, 4},
        {7, 6, 7, 5, 4, 5, 3, 2, 3, 1}
        // {8, 7, 6, 6, 5, 4, 5, 3, 2, 4, 2, 1}
    };
    static int[][][] dp;
    
    
    public int solution(String numbers) {
        int len = numbers.length() + 1;
        dp = new int[10][10][len];
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = 0; k < len; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(numbers,3, 5, 0);
    }
    
    public int dfs(String numbers, int left, int right, int depth) {
        if (depth == numbers.length()) {
            return 0;
        }
        
        if(dp[left][right][depth] != -1) {
            return dp[left][right][depth];
        }
        
        int ret = Integer.MAX_VALUE;
        
        char ch = numbers.charAt(depth);
        int num = ch - '0';
        num = (num != 0 ? num - 1 : 9);
        
        if(num != left) {
            ret = Math.min(ret, dfs(numbers, left, num, depth + 1) + board[right][num]);
        }
        
        if(num != right) {
            ret = Math.min(ret, dfs(numbers, num, right, depth + 1) + board[left][num]);
        }
        
        return dp[left][right][depth] = ret;
    }
}
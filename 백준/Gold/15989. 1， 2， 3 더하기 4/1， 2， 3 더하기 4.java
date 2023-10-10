

import java.util.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] dp2 = new int[10001];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[10001][4];

        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = 1;
        }
//        dp[]
        dp[2][2] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        dp[4][2] = 2;
        dp[4][3] = 1;

        for (int i = 5; i < dp.length; i++) {
            dp[i][2] = i / 2;
            int j = i;
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
//            while (j >= 3) {
//                j -= 3;
//                dp[i][3] += dp[j][2] + 1;
//            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3]);
            if(i != t-1) {
                sb.append('\n');
            }
        }
        he();
        for(int i = 1; i <= 10000; i++) {
            if(dp2[i] != dp[i][1] + dp[i][2] + dp[i][3]) {
                System.out.println("hello" + i);
            }
        }

        System.out.println(sb);
    }

    public static void he() {
        dp2[0] = 1;
        dp2[1] = 1;
        dp2[2] = 2;
        dp2[3] = 3;
        dp2[4] = 4;
        dp2[5] = 5;
        for(int i = 6; i <= 10000; i++) {
            dp2[i] = dp2[i-1] + dp2[i-2] - dp2[i-3] + dp2[i-3] - dp2[i-4] - (dp2[i-5] - dp2[i-6]);
        }
    }

}

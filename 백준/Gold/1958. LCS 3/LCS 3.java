
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/*
        6:02 ~
        dp[i][j] : 1 ~ i, 1 ~ j 까지 최장 공통 수열
        dp[i][j] = dp[i-1][j-1] + (일치), dp[i-1][j], dp[i][j-1]
 */
public class Main {

    static int[][][] dp;
    static char[] first, second, third;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        first = sc.nextLine().toCharArray();
        second = sc.nextLine().toCharArray();
        third = sc.next().toCharArray();
        dp = new int[first.length + 1][second.length + 1][third.length + 1];

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                for (int k = 1; k <= third.length; k++) {
                    dp[i][j][k] = dp[i - 1][j - 1][k - 1] +
                            ((first[i - 1] == second[j - 1] && second[j-1] == third[k-1]) ? 1 : 0);
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k]);
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k-1]);
                }
            }
        }

        System.out.println(dp[first.length][second.length][third.length]);
    }
}

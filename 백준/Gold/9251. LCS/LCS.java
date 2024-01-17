
import java.util.Scanner;

/*
        6:02 ~
        dp[i][j] : 1 ~ i, 1 ~ j 까지 최장 공통 수열
        dp[i][j] = dp[i-1][j-1] + (일치), dp[i-1][j], dp[i][j-1]
 */
public class Main {

    static int[][] dp;
    static char[] first, second;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        first = sc.nextLine().toCharArray();
        second = sc.nextLine().toCharArray();
        dp = new int[first.length + 1][second.length + 1];

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                dp[i][j] = dp[i - 1][j - 1] + (first[i - 1] == second[j - 1] ? 1 : 0);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
//                System.out.print(dp[i][j] + " ");
            }
//            System.out.println();
        }
        System.out.println(dp[first.length][second.length]);
    }
}

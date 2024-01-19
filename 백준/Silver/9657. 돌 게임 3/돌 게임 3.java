
import java.util.Scanner;

/*
        1:41 ~
 */
public class Main {

    public static void main(String[] args) {
        int n = new Scanner(System.in).nextInt();
        boolean[] dp = new boolean[1001];
        dp[1] = true;
        dp[3] = true;
        dp[4] = true;

        for (int i = 5; i <=n ;i++) {
            dp[i] = !dp[i-1] || !dp[i-3] || !dp[i-4];
        }
        System.out.println(dp[n] ? "SK" : "CY");
    }
}

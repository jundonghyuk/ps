
import java.util.Scanner;

/*
        10:13 ~
        dp[i] i번째 에서 마지막으로 가져감
 */
public class Main {

    public static void main(String[] args) {

        int n = new Scanner(System.in).nextInt();
        boolean[] dp = new boolean[n + 1];
        if(n==1) {
            System.out.println("SK");
            return;
        } else if(n==2) {
            System.out.println("CY");
            return;
        }
        dp[1] = true;
        dp[3] = true;
        for (int i = 4; i <= n; i++) {
            dp[i] = !dp[i - 3] || !dp[i - 1];
        }
        System.out.println(dp[n] ? "SK" : "CY");
    }
}

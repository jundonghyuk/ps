
import java.util.Scanner;

/*
11:58 ~

        dp[i] i번쨰까지 해석될 수 있는 경우의 수
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        long[] dp = new long[len + 1];
        if (s.startsWith("0")) {
            System.out.println(0);
            return;
        }
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            int idx = i - 1;
            boolean success = false;
            char prev = s.charAt(idx - 1);
            char cur = s.charAt(idx);
            if (cur >= '1' && cur <= '9') {
                dp[i] += dp[i - 1];
                success = true;
            }
            int number = 10 * (prev - '0') + (cur - '0');
            if (number >= 10 && number <= 26) {
                dp[i] += dp[i - 2];
                success = true;
            }
            if (!success) {
                System.out.println(0);
                return;
            }
            dp[i] %= 1000000;
        }
//        for (int i = 1; i <= len; i++) {
//            System.out.print(dp[i]);
//        }
        System.out.println(dp[len]);
    }
}

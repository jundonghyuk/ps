
import java.util.Scanner;

/*
        3:55 ~
        dp[i][i] i번째 사람이 제자리에 앉음

 */
public class Main {

    static int n, m;
    static int[] dp = new int[42];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= 40; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        int ret = 1;
        int prev = 0;
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            ret *= dp[num - prev - 1];
            prev = num;
        }
        ret *= dp[(n- prev)];
        System.out.println(ret);
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] t;
    static int[] p;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        t = new int[N+100];
        p = new int[N+100];
        dp = new int[N+100];
        for(int i = 1; i <= N; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        Arrays.fill(dp, 0);
        for (int i = N; i >= 1; i--) {
            if(t[i] + i  > N + 1) {
                dp[i] = dp[i+1];
            } else {
                dp[i] = Math.max(dp[i+1], p[i] + dp[i+t[i]]);
            }
        }
        System.out.println(dp[1]);
    }
}

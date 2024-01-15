
import java.util.Arrays;
import java.util.Scanner;

/*
        5:13 ~
 */
public class Main {
    static int n, k;
    static int[] coin;
    // dp[i]
    static int[] dp = new int[10001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        dp[0] = 1;
        Arrays.sort(coin);
        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <=k ;j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[k]);
    }
}

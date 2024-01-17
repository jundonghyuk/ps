
import java.util.Scanner;

/*
        10:27 ~
 */
public class Main {

    static int n, m;
    static boolean[][] dp;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            int l = i;
            int r = i;
            while (true) {
                if (l <= 0 || r > n) break;
                if (arr[l] == arr[r]) {
                    dp[l][r] = true;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            int l = i-1;
            int r = i;
            while (true) {
                if (l <= 0 || r > n) break;
                if (arr[l] == arr[r]) {
                    dp[l][r] = true;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            sb.append(dp[sc.nextInt()][sc.nextInt()] ? 1: 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

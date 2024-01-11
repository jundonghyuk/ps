
import java.util.Scanner;

/*
        8:16 ~
 */
public class Main {

    static int n;
    static int[][] arr;
    /*
        dp[i]는 i일에 끝마치는 최대

     */
    static int[] dp;
    static int max = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1][2];
        dp = new int[n + 1000];
        for (int i = 1; i <= n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for (int i = 1; i <= n ;i++) {
            int next = i + arr[i][0] - 1;
            dp[next] = Math.max(dp[next], max + arr[i][1]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n, m;
    static int[] arr, dp, sum;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n+1];
        dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            dp[i] = dp[i-1] + arr[i];
        }
        sum = new int[n * (n+1) / 2];
        int cnt = 0;
        for (int i =1 ; i<=n;i++) {
            for (int j = 0; j < i; j++) {
                sum[cnt] = dp[i] -dp[j];
                cnt++;
            }
        }
        int ret = 0;
        for (int i : sum) {
            if(i == m) {
                ret++;
            }
        }
        System.out.println(ret);
    }
}

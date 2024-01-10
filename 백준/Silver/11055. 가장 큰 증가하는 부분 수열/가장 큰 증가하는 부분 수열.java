
import java.util.Scanner;

public class Main {

    static int n;
    static int[] arr = new int[1001];

    // dp[i] : i번째 수를 마지막으로 하는 가장 긴 증가하는 부분 수열의 합
    static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + arr[i];
        }
        int ret= 0;
        for (int i =1;i<=n;i++) {
            ret = Math.max(ret, dp[i]);
        }
        System.out.println(ret);
    }
}

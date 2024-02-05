
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long[] arr = new long[n + 1];
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = dp[i - 1] + arr[i];
        }

        int start = 0;
        int end = 0;
        long ret = Integer.MAX_VALUE;
        for (end = 0; end <= n; end++) {
            while(dp[end] - dp[start] >= s) {
                ret = Math.min(ret, end - start);
                start++;
            }
        }
        System.out.println(ret == Integer.MAX_VALUE ? 0 : ret);
    }
}

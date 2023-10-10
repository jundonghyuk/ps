
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(st.nextToken());
        int[] dp = new int[10001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        for(int i = 6; i <= 10000; i++) {
            dp[i] = dp[i-1] + dp[i-2] - dp[i-3] + dp[i-3] - dp[i-4] - (dp[i-5] - dp[i-6]);
        }
        while (T-- > 0) {
            int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            System.out.println(dp[n]);
        }
    }
}

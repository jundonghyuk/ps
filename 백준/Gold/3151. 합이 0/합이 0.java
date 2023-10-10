
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

        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[30001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            dp[num + 10000] += 1;
        }
        long sum = 0;
        // -10000 ~ 0
        for (int i = 0; i <= 10000; i++) {
            if (dp[i] == 0) {
                continue;
            }
            for (int j = i; j <= 30000 - i - j; j++) {

                if (dp[j] == 0) {
                    continue;
                }
                if (i + j > 20000) {
                    continue;
                }
                if (dp[30000 - i - j] == 0) {
                    continue;
                }
                // 2 -> 10002
                int a = dp[i];
                // 3 -> 10003
                int b = dp[j];

                // -5 -> 9995
                int k = 30000 - i - j;
                int c = dp[30000 - i - j];
                if (i == j && j != k) {
                    sum += (long) c * a * (a - 1) / 2;
                } else if (i == k && i != j) {
                    sum += (long) b * a * (a - 1) / 2;
                } else if (j == k && j != i) {
                    sum += (long) a * b * (b - 1) / 2;
                } else if (i == j && i == k) {
                    sum += (long) a * (a - 1) * (a - 2) / 6;
                } else {
                    sum += (long) a * b * c;
                }
            }
        }
        System.out.println(sum);
    }
}

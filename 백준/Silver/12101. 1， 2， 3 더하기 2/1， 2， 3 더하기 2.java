
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Main {
    static int[] nums = new int[11];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        nums[0] = 1;
        nums[1] = 1;
        nums[2] = 2;
        for (int i = 3; i <= 10; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
        }
        if (nums[N] < K) {
            System.out.println(-1);
            return;
        }
        System.out.println(dfs(N, K));
    }

    private static String dfs(int n, int k) {
        if (n == 1 && k == 1) {
            return "1";
        }
        if (n == 2 && k == 2) {
            return "2";
        }
        if (n == 3 && k == 4) {
            return "3";
        }

        if (nums[n - 1] >= k) {
            return "1+" + dfs(n - 1, k);
        }
        k -= nums[n - 1];
        if (nums[n - 2] >= k) {
            return "2+" + dfs(n - 2, k);
        }
        k -= nums[n - 2];
        return "3+" + dfs(n - 3, k);
    }
}

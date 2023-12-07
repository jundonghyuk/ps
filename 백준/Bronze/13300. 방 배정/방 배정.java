
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] students = new int[2][7];

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            students[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
        }
        int ret = 0;
        for (int i = 1; i <= 6; i++) {
            ret += students[0][i] % K == 0 ? students[0][i] / K : students[0][i] / K + 1;
            ret += students[1][i] % K == 0 ? students[1][i] / K : students[1][i] / K + 1;
        }
        System.out.println(ret);
    }
}

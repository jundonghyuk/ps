
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            int[] moneys = new int[10001];
            Arrays.fill(moneys, 0);
            moneys[0] = 1;
            List<Integer> coins = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                coins.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            for (int i = 0; i < coins.size(); i++) {
                Integer coin = coins.get(i);
                for (int j = coin; j <= M; j++) {
                    moneys[j] += moneys[j - coin];
                }
            }
            System.out.println(moneys[M]);
        }
    }
}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ret = 0;

    public static void main(String[] args) throws Exception {
        int sum = 0;
        long[][] map = new long[65][10];
        for (int i = 0; i <= 9; i++) {
            map[1][i] = i + 1;
        }
        for (int i = 2; i <= 64; i++) {
            for (int j = 0; j <= 9; j++) {
                map[i][j] = (j == 0) ? map[i - 1][j] : map[i - 1][j] + map[i][j - 1];
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            System.out.println(map[number][9]);
        }
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ret = new int[2];
    static int N;
    static int[][] board = new int[130][130];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rec(0, N, 0, N);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }

    public static void rec(int sr, int er, int sc, int ec) {
        int num = board[sr][sc];
        boolean suc = true;
        for (int i = sr; i < er; i++) {
            for (int j = sc; j < ec; j++) {
                if (board[i][j] != num) {
                    suc = false;
                    break;
                }
            }
            if (!suc) {
                break;
            }
        }
        if (suc) {
            ret[num]++;
            return;
        }
        int nextRange = (er - sr + 1) / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                rec(sr + i * nextRange,
                        sr + (i + 1) * nextRange,
                        sc + j * nextRange,
                        sc + (j + 1) * nextRange);
            }
        }
    }
}

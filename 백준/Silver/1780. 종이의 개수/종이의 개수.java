
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ret = new int[3];
    static int N;
    static int[][] board = new int[3000][3000];

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
        System.out.println(ret[2]);
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
            ret[num + 1]++;
            return;
        }
        int nextRange = (er - sr + 1) / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                rec(sr + i * nextRange,
                        sr + (i + 1) * nextRange,
                        sc + j * nextRange,
                        sc + (j + 1) * nextRange);
            }
        }
    }
}

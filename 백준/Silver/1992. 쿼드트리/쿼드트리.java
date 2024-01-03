
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] ret = new int[2];
    static int N;
    static int[][] board = new int[65][65];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(rec(0, N, 0, N, ""));

    }

    public static String rec(int sr, int er, int sc, int ec, String s) {
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
            return s + num;
        }
        int nextRange = (er - sr + 1) / 2;
        s =  s +"(";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                s =rec(sr + i * nextRange, sr + (i + 1) * nextRange,
                        sc + j * nextRange, sc + (j + 1) * nextRange,
                        s);
            }
        }
        return s + ")";
    }
}

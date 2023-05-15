import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int length = 0;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = sc.next();
            int t = 0;
            for (char ch : temp.toCharArray()) {
                if (ch == '0') {
                    map[i][t] = 0;
                    dp[i][t] = 0;
                } else {
                    map[i][t] = 1;
                    dp[i][t] = 1;
                    length = 1;
                }
                t++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    continue;
                }
                if (i == 0 || j == 0) {
                    continue;
                }
                if (map[i - 1][j - 1] == 0) {
                    continue;
                }
                int diff = map[i - 1][j - 1];
                int mark = diff;
                for (int k = 1; k <= diff; k++) {
                    if (map[i - k][j] == 0 || map[i][j - k] == 0) {
                        mark = k - 1;
                        break;
                    }
                }
                map[i][j] += mark;
                length = Math.max(length, map[i][j]);

            }
        }

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(length * length);
    }
}

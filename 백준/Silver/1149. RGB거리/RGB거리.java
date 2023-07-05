
import java.util.Scanner;

public class Main {

    static int[][] map;
    static int[][] dp;
    static int N;
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][3];
        dp = new int[N][3];

        // init
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                map[i][j] = sc.nextInt();
                if(i == 0) {
                    dp[i][j] = map[i][j];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for(int i = 1; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if( j== k) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + map[i][j]);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            ret = Math.min(ret, dp[N-1][i]);
        }

        System.out.println(ret);
    }
}

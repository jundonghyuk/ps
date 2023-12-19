

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int DAY = 0;
    static int NIGHT = 1;
    static int[][] board = new int[1001][1001];
    static int[][][] vis = new int[1001][1001][11];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = line[j] - '0';
            }
        }
        Queue<int[]> q = new LinkedList<>();
        vis[0][0][0] = 1;
        q.add(new int[]{0, 0, 0, DAY});
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            int nextDay =loc[3] == DAY ? NIGHT : DAY;
            if (loc[0] == N - 1 && loc[1] == M - 1) {
//                calculate();
                System.out.println(vis[N-1][M-1][loc[2]]);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = loc[0] + dx[dir];
                int ny = loc[1] + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (loc[3] == DAY && board[nx][ny] == 1 && loc[2] < K && vis[nx][ny][loc[2] + 1] == 0) {
                    vis[nx][ny][loc[2] + 1] = vis[loc[0]][loc[1]][loc[2]] + 1;
                    q.add(new int[]{nx, ny, loc[2] + 1, NIGHT});
                } else if (board[nx][ny] == 0 && vis[nx][ny][loc[2]] == 0) {
                    vis[nx][ny][loc[2]] = vis[loc[0]][loc[1]][loc[2]] + 1;
                    q.add(new int[]{nx, ny, loc[2], nextDay});
                }
            }
            if (loc[3] == NIGHT && loc[2] < K) {
                vis[loc[0]][loc[1]][loc[2]] = vis[loc[0]][loc[1]][loc[2]] + 1;
                q.add(new int[]{loc[0], loc[1], loc[2], DAY});
            }
        }
        System.out.println(-1);
    }
}

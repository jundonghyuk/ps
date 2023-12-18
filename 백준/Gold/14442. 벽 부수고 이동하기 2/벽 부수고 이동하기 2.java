
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
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
        q.add(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            if (loc[0] == N - 1 && loc[1] == M - 1) {
                calculate();
                System.out.println(ret);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = loc[0] + dx[dir];
                int ny = loc[1] + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (board[nx][ny] == 1 && loc[2] < K && vis[nx][ny][loc[2] + 1] == 0) {
                    vis[nx][ny][loc[2] + 1] = vis[loc[0]][loc[1]][loc[2]] + 1;
                    q.add(new int[]{nx, ny, loc[2] + 1});
                } else if (board[nx][ny] == 0 && vis[nx][ny][loc[2]] == 0) {
                    vis[nx][ny][loc[2]] = vis[loc[0]][loc[1]][loc[2]] + 1;
                    q.add(new int[]{nx, ny, loc[2]});
                }
            }
        }
        System.out.println(-1);
    }

    public static void calculate() {
        for (int i = 0; i <= K; i++) {
            if (vis[N - 1][M - 1][i] == 0) {
                continue;
            }
            ret = Math.min(ret, vis[N - 1][M - 1][i]);
        }
    }
}

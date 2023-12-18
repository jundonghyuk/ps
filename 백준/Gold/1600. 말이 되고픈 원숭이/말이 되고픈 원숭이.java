
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int K, W, H;
    static int[][] board = new int[301][301];
    static int[][][] vis = new int[301][301][31];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] knightDx = {2, 2, 1, 1, -1, -1, -2, -2};
    static int[] knightDy = {1, -1, 2, -2, 2, -2, 1, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for (int k = 0; k <= K; k++) {
                    vis[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        vis[0][0][0] = 0;
        q.add(new int[]{0, 0, 0});
        while (!q.isEmpty()) {
            int[] loc = q.poll();
            if (loc[2] < K) {
                for (int dir = 0; dir < 8; dir++) {
                    int nx = loc[0] + knightDx[dir];
                    int ny = loc[1] + knightDy[dir];

                    if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                        continue;
                    }
                    if (board[nx][ny] == 1) {
                        continue;
                    }
                    if (vis[nx][ny][loc[2] + 1] > vis[loc[0]][loc[1]][loc[2]] + 1) {
                        vis[nx][ny][loc[2] + 1] = vis[loc[0]][loc[1]][loc[2]] + 1;
                        q.add(new int[]{nx, ny, loc[2] + 1});
                    }
                }
            }

            for (int dir = 0; dir < 4; dir++) {
                int nx = loc[0] + dx[dir];
                int ny = loc[1] + dy[dir];

                if (nx < 0 || ny < 0 || nx >= H || ny >= W) {
                    continue;
                }
                if (board[nx][ny] == 1) {
                    continue;
                }
                if (vis[nx][ny][loc[2]] > vis[loc[0]][loc[1]][loc[2]] + 1) {
                    vis[nx][ny][loc[2]] = vis[loc[0]][loc[1]][loc[2]] + 1;
                    q.add(new int[]{nx, ny, loc[2]});
                }
            }
        }
//        for (int i =0 ; i < H; i++) {
//            for (int j = 0; j < W; j++) {
//                System.out.print(vis[i][j][1]+" ");
//            }
//            System.out.println();
//        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i <= K; i++) {
//            System.out.println(vis[H-1][W-1][i]);
            ret = Math.min(ret, vis[H - 1][W - 1][i]);
        }
        if (ret == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ret);
    }
}

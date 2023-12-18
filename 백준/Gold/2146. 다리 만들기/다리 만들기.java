
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] board = new int[101][101];
    static boolean[][] vis = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int color = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vis[i][j] || board[i][j] == 0) continue;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j});
                vis[i][j] = true;
                while (!q.isEmpty()) {
                    int[] loc = q.poll();
                    board[loc[0]][loc[1]] = color;
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = loc[0] + dx[dir];
                        int ny = loc[1] + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (vis[nx][ny] || board[nx][ny] == 0) continue;
                        q.add(new int[]{nx, ny});
                        vis[nx][ny] = true;
                    }
                }
                color++;
            }
        }
//        for (int i = 0; i < N;i++)  {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
        int ret = 401;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;
                int cur = board[i][j];
                vis = new boolean[101][101];
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{i, j, 0});
                vis[i][j] = true;
                boolean find = false;
                while (!q.isEmpty()) {
                    int[] loc = q.poll();
                    if(loc[2] > ret) {
                        break;
                    }
                    for (int dir = 0; dir < 4; dir++) {
                        int nx = loc[0] + dx[dir];
                        int ny = loc[1] + dy[dir];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if (vis[nx][ny] || board[nx][ny] == cur) continue;
                        if (board[nx][ny] != 0) {
                            ret = Math.min(ret, loc[2]);
                            find = true;
                            break;
                        }
                        q.add(new int[]{nx, ny, loc[2] + 1});
                        vis[nx][ny] = true;
                    }
                    if (find) {
                        break;
                    }
                }
            }
        }
        System.out.println(ret);
    }
}

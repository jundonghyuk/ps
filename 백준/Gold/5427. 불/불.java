
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int T, N, M;
    static char WALL = '#';
    static char ME = '@';
    static char EMPTY = '.';
    static char FIRE = '*';

    static char[][] board = new char[1001][1001];
    static int[][] dist = new int[1001][1001];
    static boolean[][] vis = new boolean[1001][1001];
    static boolean[][] vis2 = new boolean[1001][1001];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] nm = br.readLine().split(" ");
            N = Integer.parseInt(nm[1]);
            M = Integer.parseInt(nm[0]);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                    vis[i][j] = false;
                    vis2[i][j] = false;
                }
            }

            int startX = 0;
            int startY = 0;
            List<int[]> fires = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    board[i][j] = line[j];
                    if (line[j] == ME) {
                        startX = i;
                        startY = j;
                    } else if (line[j] == FIRE) {
                        fires.add(new int[]{i, j});
                    }
                }
            }

            Queue<int[]> q = new LinkedList<>();
            for (int[] fire : fires) {
                q.add(new int[]{fire[0], fire[1]});
                dist[fire[0]][fire[1]] = 0;
                vis2[fire[0]][fire[1]] = true;
            }

            while (!q.isEmpty()) {
                int[] location = q.poll();
                int x = location[0];
                int y = location[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (vis2[nx][ny] || board[nx][ny] == WALL) continue;

                    q.add(new int[]{nx, ny});
                    vis2[nx][ny] = true;
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }

//            for (int i = 0; i < N; i++) {
//                for(int j = 0; j < M; j++) {
//                    System.out.print(dist[i][j] + " ");
//                }
//                System.out.println();
//            }
            q.add(new int[]{startX, startY, 0});
            vis[startX][startY] = true;
            boolean escape = false;
            while (!q.isEmpty()) {
                int[] location = q.poll();
                int x = location[0];
                int y = location[1];
                int val = location[2];
                if (x == 0 || y == 0 || x == N - 1 || y == M - 1) {
                    System.out.println(val + 1);
                    escape = true;
                    break;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (vis[nx][ny] || board[nx][ny] == WALL || dist[nx][ny] <= val + 1) continue;

                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny, val + 1});
                }
            }
            if(!escape) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}

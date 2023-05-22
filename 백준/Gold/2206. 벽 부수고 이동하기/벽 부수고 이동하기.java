import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static ArrayList<int[]> walls;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ret = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];
        walls = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(String.valueOf(line.charAt(j)));
                map[i][j] = temp;
                if (map[i][j] == 1) {
                    walls.add(new int[]{i, j});
                }
            }
        }

        bfs();
        if (ret != Integer.MAX_VALUE) {
            System.out.println(ret);
        } else {
            System.out.println(-1);
        }
    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] source = queue.poll();
            int row = source[0];
            int col = source[1];
            int depth = source[2];
            int blocked = source[3];
            if (depth > ret) {
                return;
            }
            if (row == N - 1 && col == M - 1) {
                ret = Math.min(ret, depth);
            }

            for (int i = 0; i < 4; i++) {
                int nx = row + dx[i];
                int ny = col + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue;
                }
            
                if (blocked == 1) {
                    if(visited[0][nx][ny] || visited[1][nx][ny] || map[nx][ny] == 1) {
                        continue;
                    } else {
                        visited[1][nx][ny] = true;
                        queue.add(new int[]{nx, ny, depth + 1, 1});
                    }
                } else {
                    if(visited[0][nx][ny]) {
                        continue;
                    }
                    if(map[nx][ny] == 0) {
                        visited[0][nx][ny] = true;
                        queue.add(new int[]{nx, ny, depth + 1, 0});
                    } else {
                        if(visited[1][nx][ny]) {
                            continue;
                        } else {
                            visited[1][nx][ny] = true;
                            queue.add(new int[]{nx, ny, depth+1, 1});
                        }
                    }
                }
            }
        }
    }
}

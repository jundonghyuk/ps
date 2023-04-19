import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] map;
    static int[][] visited;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String seq = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = seq.charAt(j) == '1';
            }
        }
        bfs(0, 0);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(visited[N-1][M-1]));
        bw.flush();
    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = 1;
        queue.offer(new int[]{row, col});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            if (poll[0] == N - 1 && poll[1] == M - 1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + poll[0];
                int ny = dy[i] + poll[1];
                if (ny < 0 || ny >= M || nx < 0 || nx >= N || !map[nx][ny] || visited[nx][ny] != 0 ) {
                    continue;
                }
                queue.offer(new int[]{nx, ny});
                visited[nx][ny] = visited[poll[0]][poll[1]] + 1;
            }
        }
    }

}

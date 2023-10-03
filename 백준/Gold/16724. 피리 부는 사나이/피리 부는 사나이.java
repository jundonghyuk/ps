
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};
    static char dir[] = {'U', 'L', 'D', 'R'};
    static int ret = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            char[] charArray = line.toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = charArray[j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    continue;
                }
                ret++;
                queue.add(new int[]{i, j});
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int row = poll[0];
                    int col = poll[1];
                    char direction = map[row][col];
                    for (int k = 0; k < 4; k++) {
                        int nx = row + dx[k];
                        int ny = col + dy[k];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                            continue;
                        }
                        if (map[nx][ny] != dir[k]) {
                            continue;
                        }
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                    if (direction == 'U' && row != 0 && !visited[row - 1][col]) {
                        queue.add(new int[]{row - 1, col});
                        visited[row - 1][col] = true;
                    } else if (direction == 'D' && row != N - 1 && !visited[row + 1][col]) {
                        queue.add(new int[]{row + 1, col});
                        visited[row + 1][col] = true;
                    } else if (direction == 'L' && col != 0 && !visited[row][col - 1]) {
                        queue.add(new int[]{row, col - 1});
                        visited[row][col - 1] = true;
                    } else if (direction == 'R' && col != M - 1 && !visited[row][col + 1]) {
                        queue.add(new int[]{row, col + 1});
                        visited[row][col + 1] = true;
                    }
                }
            }
        }
        System.out.println(ret);
    }
}

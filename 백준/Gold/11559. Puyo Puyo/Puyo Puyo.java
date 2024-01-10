
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
        12:20 ~
        1. 터트린다. (bfs) 72 * 18
        2. 아래로 내린다 (72 * 12) = 1000..

 */
public class Main {
    static int R = 12;
    static int C = 6;
    static char[][] board = new char[R][C];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }
        int ret = 0;
        while(hit()) {
            ret++;
            down();
        }
//        for (int i = 0; i < R; i++) {
//            for (int j = 0 ; j < C; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(ret);
    }

    public static boolean hit() {
        boolean[][] visited = new boolean[R][C];
        boolean success = false;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '.' || visited[i][j]) continue;
                char letter = board[i][j];

                Queue<int[]> q = new LinkedList<>();
                visited[i][j] = true;
                q.add(new int[]{i, j});
                int cnt = 0;
                List<int[]> position = new ArrayList<>();
                while (!q.isEmpty()) {
                    int[] location = q.poll();
                    position.add(location);
                    cnt++;
                    int x = location[0];
                    int y = location[1];

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        if (nx < 0 || ny < 0 || nx >= R || ny >= C || visited[nx][ny] || board[nx][ny] != letter)
                            continue;
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
                if (cnt >= 4) {
                    for (int[] pos : position) {
                        board[pos[0]][pos[1]] = '.';
                    }
                    success = true;
                }
            }
        }
        return success;
    }

    public static void down() {
        for (int i = R - 2; i >= 0; i--) {
            for (int j = 0; j < C; j++) {
                int nextR = i + 1;
                while (nextR <= R - 1 && board[nextR][j] == '.') {
                    nextR++;
                }
                nextR--;
                if (i != nextR) {
                    board[nextR][j] = board[i][j];
                    board[i][j] = '.';
                }
            }
        }
    }
}


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
        3:25 ~
 */
public class Main {

    static int N, M, P;
    static char[][] board = new char[1001][1001];
    static int[][][] vis = new int[1001][1001][2];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] weight = new int[10];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < P; i++) {
            weight[i + 1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    vis[i][j][0] = 0;
                    vis[i][j][1] = weight[board[i][j] - '0'];
                }
            }
        }
        Deque<int[]>[] deque = new ArrayDeque[10];
        for (int i = 1; i <= P; i++) {
            deque[i] = new ArrayDeque<>();
        }
        for (int k = 1; k <= P; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == k + '0') {
                        deque[k].addLast(new int[]{i, j, weight[k], 1});
                    }
                }
            }
        }
        while (true) {
            boolean toContinue = false;
            for (int i = 1; i <= P; i++) {
                Deque<int[]> dq = deque[i];
                Deque<int[]> next = new ArrayDeque<>();
                while (!dq.isEmpty()) {
                    int[] loc = dq.pollFirst();
                    int x = loc[0];
                    int y = loc[1];
                    int w = loc[2];
                    int stage = loc[3];
                    char num = board[x][y];

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];
                        int nw = w - 1;

                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (board[nx][ny] >= '1' && board[nx][ny] <= '9') continue;
                        if (board[nx][ny] == '#') continue;

                        if (board[nx][ny] == '.') {
                            if (nw == 0) {
                                board[nx][ny] = num;
                                vis[nx][ny][0] = stage;
                                vis[nx][ny][1] = nw;
                                next.addLast(new int[]{nx, ny, weight[num - '0'], stage + 1});
                            } else {
                                board[nx][ny] = num;
                                vis[nx][ny][0] = stage;
                                vis[nx][ny][1] = nw;
                                dq.addLast(new int[]{nx, ny, nw, stage});
                            }
                        }
                        toContinue = true;
                    }
//
                }
                deque[i] = next;
            }
            if(!toContinue) {
                break;
            }
        }
        int[] ans = new int[10];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
//                System.out.print(board[i][j] + " ");
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    ans[board[i][j] - '0']++;
                }
            }
//            System.out.println();
        }

        for (int i = 1; i <= P; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}

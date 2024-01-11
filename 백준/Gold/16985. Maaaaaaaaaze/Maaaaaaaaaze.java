
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
        7:38 ~
        120(5!) * 4 * 4 * 4 * 4 * 4  * 125
        = 120 * 1024 * 125

        1. 보드를 돌린다. 1024가지 (회전 구현)
        2. 보드를 1 ~5번으로 랜덤 배치한다.
        3. (0,0,0) -> (4,4,4) bfs 돌린다.

 */
public class Main {

    static boolean[][][][] board = new boolean[5][4][5][5];
    static boolean[][][] temp = new boolean[5][5][5];
    static boolean[][][] visited;
    static int[] rotate = new int[5];
    static int[] permutation = new int[5];
    static boolean[] issued = new boolean[5];
    static int ret = 500;

    public static int[] dx = {1, 0, 0, -1, 0, 0};
    public static int[] dy = {0, 1, 0, 0, -1, 0};
    public static int[] dz = {0, 0, 1, 0, 0, -1};

    public static void main(String[] args) {
        inputBoard();
        initializeRotation();
       
        for (int i = 0; i < 1024; i++) {
            int num = i;
            for (int k = 0; k < 5; k++) {
                rotate[k] = num % 4;
                num /= 4;
            }
            permutation(0);
        }
        System.out.println(ret == 500 ? -1 : ret);
    }

    public static void inputBoard() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    board[i][0][j][k] = sc.nextInt() == 1;
                }
            }
        }
    }

    public static void initializeRotation() {
        for (int i = 0; i < 5; i++) {
            for (int count = 1; count <= 3; count++) {
                board[i][count] = rotate(board[i][count - 1]);
            }
        }
    }

    public static boolean[][] rotate(boolean[][] origin) {
        boolean[][] next = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                next[i][j] = origin[4 - j][i];
            }
        }
        return next;
    }

    public static void initializeVisit() {
        visited = new boolean[5][5][5];
    }

    public static void permutation(int depth) {
        if (depth == 5) {
            initializeVisit();
            setBoard();
            bfs();
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (issued[i]) continue;
            permutation[depth] = i;
            issued[i] = true;
            permutation(depth + 1);
            issued[i] = false;
        }
    }

    public static void setBoard() {
        for (int i = 0; i < 5; i++) {
            temp[i] = board[permutation[i]][rotate[permutation[i]]];
        }
    }

    public static void bfs() {
        if (!temp[0][0][0]) {
            return;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;
        while (!q.isEmpty()) {

            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int z = poll[2];
            int dist = poll[3];

            if (x == 4 && y == 4 && z == 4) {
                ret = Math.min(ret, dist);
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= 5 || ny >= 5 || nz >= 5) continue;
                if (visited[nx][ny][nz] || !temp[nx][ny][nz]) continue;
                q.add(new int[]{nx, ny, nz, dist + 1});
                visited[nx][ny][nz] = true;
            }
        }
    }
}

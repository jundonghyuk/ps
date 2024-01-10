
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
        1:45 ~
        1. 보드에서 다음 위치를 찾는다.
        2. 굴린 방향대로 주사위의 상태를 바꾼다.
        3. 보드의 수를 바꾼다.

 */

public class Main {
    static int n, m, x, y, k;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    /*
            0, 3 밑, 위
            1, 4 동, 서
            2, 5 남, 북
     */
    static int DOWN = 0;
    static int UP = 3;
    static int EAST = 1;
    static int WEST = 4;
    static int SOUTH = 2;
    static int NORTH = 5;
    static int[] dice = {0, 0, 0, 0, 0, 0};
    static int[][] board;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        x = Integer.parseInt(line[2]);
        y = Integer.parseInt(line[3]);
        k = Integer.parseInt(line[4]);
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                continue;
            }
            rotate(dir);
            x = nx;
            y = ny;
            if (board[x][y] ==0) {
                board[x][y] = dice[DOWN];
            } else {
                dice[DOWN] = board[x][y];
                board[x][y] = 0;
            }
            System.out.println(dice[UP]);
//                System.out.println("east :" + dice[EAST]);
        }
    }

    public static void rotate(int dir) {
        int[] temp = new int[6];

        // 동 -> 북, 남 고정
        if(dir == 0) {
            temp[UP] = dice[WEST];
            temp[EAST] = dice[UP];
            temp[DOWN] = dice[EAST];
            temp[WEST] = dice[DOWN];

            temp[NORTH] = dice[NORTH];
            temp[SOUTH] = dice[SOUTH];
        }
        // 서
        else if(dir == 1) {
            temp[UP] = dice[EAST];
            temp[WEST] = dice[UP];
            temp[DOWN] = dice[WEST];
            temp[EAST] = dice[DOWN];

            temp[NORTH] = dice[NORTH];
            temp[SOUTH] = dice[SOUTH];
        }
        // 북
        else if(dir == 2) {
            temp[UP] = dice[SOUTH];
            temp[NORTH] = dice[UP];
            temp[DOWN] = dice[NORTH];
            temp[SOUTH] = dice[DOWN];

            temp[EAST] = dice[EAST];
            temp[WEST] = dice[WEST];
        }
        // 남
        else {
            temp[UP] = dice[NORTH];
            temp[SOUTH] = dice[UP];
            temp[DOWN] = dice[SOUTH];
            temp[NORTH] = dice[DOWN];

            temp[EAST] = dice[EAST];
            temp[WEST] = dice[WEST];
        }
        for (int i = 0; i <6; i++) {
            dice[i]=temp[i];
        }
    }
}

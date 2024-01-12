
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
            5:35 ~
            1. 현재 칸을 청소
            2. 주변에 청소되지 않은 빈칸이 없으면 후진
                - 뒤가 벽이거나 나가면 동작 멈춤
            3. 주변에 청소되지 않은 빈칸이 있으면
                - 반시계 90도 회전
                - 그 칸이 청소되지 않았으면 한 칸 전진
 */
public class Main {
    static int n, m;
    static int r, c, d;
    // 북 동 남 서
    /*
                true: 벽
                false: 청소안됨
     */
    static int[][] board = new int[51][51];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ret = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] location = q.poll();
            int x = location[0];
            int y = location[1];
            if (board[x][y] == 0) {
                board[x][y] = 2;
                ret++;
            }
            boolean find = false;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 1 || board[nx][ny] == 2) {
                    continue;
                }
                find = true;
            }
            if (!find) {
                int nx = x + dx[(d+2) %4];
                int ny = y + dy[(d+2) %4];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] == 1) {
                    System.out.println(ret);
//                    for (int k = 0; k< n; k++) {
//                        for (int l = 0 ; l < m;l++) {
//                            System.out.print(board[k][l] +" ");
//                        }
//                        System.out.println();
//                    }
                    return;
                } else {
                    q.add(new int[]{nx, ny});
                }
            } else {
                d= (d+3) %4;
                int nx = x + dx[d %4];
                int ny = y + dy[d %4];
                if (board[nx][ny] == 0) {
                    q.add(new int[]{nx,ny});
                } else {
                    q.add(new int[]{x, y});
                }
            }
        }
    }
}
